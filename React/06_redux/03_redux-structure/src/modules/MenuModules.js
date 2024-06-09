import {createActions, handleActions} from 'redux-actions'

/* 메뉴 모듈 */
/* 초기값 */
const initialState = {};

/* 액션 타입 */
const GET_MENULIST = 'menu/GET_MENULIST'
const GET_MENU = 'menu/GET_MENU';
const GET_REVIEW = 'review/GET_REVIEW'

/* 액션 생성함수 */
export const { menu: {getMenulist, getMenu}, review: {getReview}} = createActions({
    [GET_MENULIST]: result => ({menulist: result}),
    [GET_MENU]: result => ({menu: result}),
    [GET_REVIEW]: result => ({review: result})
});

/* 리듀서 함수 */
const menuReducer = handleActions({
    /* callGetMenuListAPI에서 dispatch 받은 getMenulist는 = GET_MENULIST 자동 변환
    * 인수로 받은 result(객체)는 {payload}에 적용 */
    [GET_MENULIST]: (state, {payload}) => payload,
    [GET_MENU]: (state, {payload}) => payload,
    [GET_REVIEW]: (state, {payload}) => payload
}, initialState);
export default menuReducer;

/* 
* dispatch(func) -> thunk func => 비동기 통신 -> dispatch(action)
* dispatch(action) -> logger func -> reducer
*/