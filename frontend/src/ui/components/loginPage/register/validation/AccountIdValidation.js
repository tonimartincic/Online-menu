import React from 'react';
import {Alert} from 'react-bootstrap';
import styles from './accountIdValidation.css';

const AccountIdValidation = () => (
  <section className={styles.section}>
    <Alert bsStyle='danger'>
      <h4>Account id cannot be empty</h4>
    </Alert>
  </section>
);

export default AccountIdValidation;
