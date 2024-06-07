import {createActions, handleActions} from 'redux-actions'

/* 메뉴 모듈 */
/* 초기값 */
const initialState = {};

/* 액션 */
/*  */
const GET_MENULIST = 'menu/GET_MENULIST'

export const { menu: {getMenulist}} = createActions({
    [GET_MENULIST]: result => ({menulist: result})
});

/* 리듀서 함수 
* handleActions: */
const menuReducer = handleActions({
    [GET_MENULIST]: (state, {payload}) => payload
}, initialState);
export default menuReducer;

/* 
* dispatch(func) -> thunk func => 비동기 통신 -> dispatch(action)
* dispatch(action) -> logger func -> reducer
*/