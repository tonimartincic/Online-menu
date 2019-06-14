import React from 'react';
import {Row, Col, FormControl} from 'react-bootstrap';

import styles from './formFields.css';

const FormFields = props => (
  <section>
    <Row>
      <Col>
        <section className={styles.section}>
          <FormControl
            type='text'
            value={props.accountId}
            placeholder='Account ID'
            onChange={props.handleChangeAccountId}
          />
        </section>
      </Col>
    </Row>
  </section>
);

export default FormFields;
