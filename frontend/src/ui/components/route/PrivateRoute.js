import React from 'react';
import {Redirect, Route} from 'react-router-dom';
import {connect} from 'react-redux';
import styles from './privateRoute.css';
import * as util from '../../../utils/Util';

const PrivateRouteComponent = (props) => (
  <Route {...props.routeProps} render={() => (
    props.account != null && !util.isEmpty(props.account) ? (
      <section className={styles.section}>{props.children}</section>
    ) : (
      <Redirect to={{
        pathname: '/login',
        state: {from: props.location}
      }}/>)
  )}/>
);

const mapStateToProps = (state, ownProps) => {
  return {
    account: state.account,
    location: ownProps.path,
    routeProps: {
      exact: ownProps.exact,
      path: ownProps.path
    }
  };
};

const PrivateRoute = connect(mapStateToProps, null)(PrivateRouteComponent);
export default connect(mapStateToProps, null, null, {
  pure: false,
})(PrivateRoute);
