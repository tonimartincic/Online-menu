import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from 'react-router-dom';
import openAccount from '../../../../redux/actionCreators/openingAccountActionCreators';
import {setOpeningAccountResponse} from '../../../../redux/actions/openingAccountActions';
import Register from './Register';

class RegisterContainer extends Component {
  constructor(props) {
    super(props);

    this.state = {
      accountId: '',
      accountIdValidation: null,
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChangeAccountId = this.handleChangeAccountId.bind(this);
    this.handleReset = this.handleReset.bind(this);
  }

  handleSubmit = (event) => {
    event.preventDefault();

    if (this.state.accountId == null || this.state.accountId.trim() === '') {
      this.setState({
        accountIdValidation: 'error',
      });

      return;
    }

    this.props.openAccount(this.state.accountId);
  };

  handleChangeAccountId = (event) => {
    this.setState({
      accountId: event.target.value,
      accountIdValidation: null,
    });
  };

  handleReset = () => {
    this.setState({
      accountId: '',
      accountIdValidation: null,
    });

    this.props.setOpeningAccountResponse(null);
  };

  render() {
    return (
      <Register
        accountId={this.state.accountId}
        handleChangeAccountId={event => this.handleChangeAccountId(event)}
        handleSubmit={event => this.handleSubmit(event)}
        handleReset={event => this.handleReset(event)}
        openingAccountResponse={this.props.openingAccountResponse}
        accountIdValidation={this.state.accountIdValidation}
      />
    );
  }
}

function mapStateToProps(state) {
  return {
    openingAccountResponse: state.openingAccountResponse,
  };
}

function mapDispatchToProps(dispatch) {
  return {
    openAccount: accountId => dispatch(openAccount(accountId)),
    setOpeningAccountResponse: () => dispatch(setOpeningAccountResponse()),
  };
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(RegisterContainer));
