import initialState from '../initialState';
import * as types from "../actionTypes";

export default function accountReducer(state = initialState.account, action) {
  switch (action.type) {
    case types.VALIDATE_ACCOUNT_SUCCESS:
      return Object.assign({}, state);

    case types.VALIDATE_ACCOUNT_FAILURE:
      return Object.assign({}, state);

    case types.GET_LOGGED_USER_SUCCESS:
      return Object.assign({}, action.data);

    case types.GET_LOGGED_USER_FAILURE:
      return Object.assign({}, state);

    case types.LOGIN_SUCCESS:
      return Object.assign({}, action.data);

    case types.LOGIN_FAILURE:
      return Object.assign({}, state);

    default:
      return Object.assign({}, state);
  }
}
