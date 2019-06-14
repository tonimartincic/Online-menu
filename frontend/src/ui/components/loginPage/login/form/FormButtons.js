import React from 'react';
import {Row, Col, Button} from 'react-bootstrap';

import styles from './formButtons.css';

const FormButtons = props => (
  <section className={styles.section}>
    <Row>
      <Col>
        <Button
          className={styles.button}
          type='submit'
          onClick={props.handleSubmit}
        >
          <span>
            <span className='glyphicon glyphicon-log-in'/> Login
          </span>
        </Button>
      </Col>
    </Row>
    <Row>
      <Col>
        <Button
          className={styles.button}
          type='button'
          onClick={props.handleReset}
        >
          <span>
            <span className='glyphicon glyphicon-remove'/> Reset
          </span>
        </Button>
      </Col>
    </Row>
  </section>
);

export default FormButtons;
