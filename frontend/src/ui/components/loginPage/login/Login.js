import React from 'react';
import {Form, Well} from 'react-bootstrap';
import LoginHeader from './header/LoginHeader';
import FormFields from './form/FormFields';
import FormButtons from './form/FormButtons';
import styles from './login.css';

const Login = props => (
  <section className={styles.section}>
    <Well className={styles.well}>
      <Form>
        <LoginHeader/>
        <FormFields
          accountId={props.accountId}
          password={props.password}
          handleChangeAccountId={event => props.handleChangeAccountId(event)}
          handleChangePassword={event => props.handleChangePassword(event)}
        />
        <FormButtons
          handleSubmit={event => props.handleSubmit(event)}
          handleReset={event => props.handleReset(event)}
        />
      </Form>
    </Well>
  </section>
);

export default Login;
