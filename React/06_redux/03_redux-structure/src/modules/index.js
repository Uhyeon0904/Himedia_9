import menuReducer from "./MenuModules";
import { combineReducers } from 'redux';

const rootReducer = combineReducers({
    menuReducer
});
export default rootReducer;