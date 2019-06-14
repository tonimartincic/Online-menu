import React from 'react';
import {Form, Well} from 'react-bootstrap';
import RegisterHeader from './header/RegisterHeader';
import FormFields from './form/FormFields';
import FormButtons from './form/FormButtons';
import AccountIdValidation from './validation/AccountIdValidation';
import OpeningAccountResponse from './openingAccountResponse/OpeningAccountResponse';
import styles from './register.css';
import * as util from '../../../../utils/Util';

const Register = props => (
  <section className={styles.section}>
    <Well className={styles.well}>
      <Form>
        <RegisterHeader/>
        <FormFields
          accountId={props.accountId}
          handleChangeAccountId={event => props.handleChangeAccountId(event)}
        />
        <FormButtons
          handleSubmit={event => props.handleSubmit(event)}
          handleReset={event => props.handleReset(event)}
        />
        <Choose>
          <When condition={props.accountIdValidation === 'error'}>
            <AccountIdValidation/>
          </When>
        </Choose>
        <Choose>
          <When condition={props.openingAccountResponse != null && !util.isEmpty(props.openingAccountResponse)}>
            <OpeningAccountResponse
              openingAccountResponse={props.openingAccountResponse}
            />
          </When>
        </Choose>
      </Form>
    </Well>
  </section>
);

export default Register;
