import { getMenu, getMenulist } from '../modules/MenuModules';
import {request} from './api'

export function callGetMenuListAPI() {
    return async (dispatch, getState) => {
        const result = await request('GET', '/menu');
        dispatch(getMenulist(result));
    }
}

/* json 파일을 서버로 구동 후 4000번의 포트번호를 사용하겠다. 
* npx json-server ./db.json --port 4000 */

/* API 호출을 통해 반환 받은 데이터를 Store에 저장하기 위해 다시 dispatch(action 객체) 한다, */

export function callGetMenuAPI(id) {
    return async (dispatch, getState) => {
        const result = await request('GET',`/menu/${id}`)
        dispatch(getMenu(result));
    }
}

export function callgetReview() {
    return async (dispatch) => {
        // 문자열이 들어가는 것이 아닌 GET방식의 request url의 + /review 요청의 데이터가 담긴다.
        // result는 action 타입이 된다.
        const result = await request('GET', '/review');
        dispatch()
    }
}