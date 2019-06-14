import React from 'react';
import {Alert} from 'react-bootstrap';
import styles from './openingAccountResponse.css';

const OpeningAccountResponse = props => (
  <section className={styles.section}>
    <Alert bsStyle={props.openingAccountResponse.success ? 'success' : 'danger'}>
      <h4>{props.openingAccountResponse.description}</h4>
      <Choose>
        <When condition={props.openingAccountResponse.success}>
          <h4>Password: {props.openingAccountResponse.password}</h4>
        </When>
      </Choose>
    </Alert>
  </section>
);

export default OpeningAccountResponse;
