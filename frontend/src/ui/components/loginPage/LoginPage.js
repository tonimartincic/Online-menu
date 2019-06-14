import React from 'react';
import {Grid, Row, Col} from 'react-bootstrap';
import PageHeader from './pageHeader/PageHeader';
import LoginContainer from './login/LoginContainer';
import RegisterContainer from './register/RegisterContainer';
import styles from './loginPage.css';

const LoginPage = () => (
  <section className={styles.section}>
    <Grid className={styles.container}>
      <Row>
        <PageHeader/>
      </Row>
      <Row>
        <Col md={4} mdOffset={1}>
          <LoginContainer/>
        </Col>
        <Col md={4} mdOffset={2}>
          <RegisterContainer/>
        </Col>
      </Row>
    </Grid>
  </section>
);

export default LoginPage;
