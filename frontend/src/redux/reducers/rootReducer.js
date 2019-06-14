import {combineReducers} from 'redux';
import accountReducer from "./accountReducer";
import openingAccountReducer from "./openingAccountReducer";

const rootReducer = combineReducers({
  account: accountReducer,
  openingAccountResponse: openingAccountReducer,
});

export default rootReducer;
