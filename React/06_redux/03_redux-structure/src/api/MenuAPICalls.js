import { getMenulist } from '../modules/MenuModules';
import {request} from './api'

export function callGetMenuListAPI() {
    return async (dispatch, getState) => {
        const result = await request('GET', '/menu');

        console.log('getMenuList result: ', result);

        dispatch(getMenulist(result));

    }
}

/* json 파일을 서버로 구동 후 4000번의 포트번호를 사용하겠다. 
* npx json-server ./db.json --port 4000 */

/* API 호출을 통해 반환 받은 데이터를 Store에 저장하기 위해 다시 dispatch(action 객체) 한다, */
