import axios from 'axios';
import * as types from '../actionTypes';

export default async function validateAccount(account) {
  try {
    await axios.post('/api/account/validate', `username=${account.username}&password=${account.password}`, {headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },});

    return {
      type: types.VALIDATE_ACCOUNT_SUCCESS,
    };
  } catch (err) {
    return {
      type: types.VALIDATE_ACCOUNT_FAILURE,
      data: err,
    };
  }
}

export async function getLoggedUser() {
  try {
    const response = await axios.get('/api/account');

    return {
      type: types.GET_LOGGED_USER_SUCCESS,
      data: response.data,
    };
  } catch (err) {
    return {
      type: types.GET_LOGGED_USER_FAILURE,
      data: err,
    };
  }
}

export async function login() {
  try {
    const response = await axios.get('/api/account');

    return {
      type: types.LOGIN_SUCCESS,
      data: response.data,
    };
  } catch (err) {
    return {
      type: types.LOGIN_FAILURE,
      data: err,
    };
  }
}
