import { useEffect } from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {callGetMenuListAPI} from '../../api/MenuAPICalls'

function MenuList() {
    const dispatch = useDispatch();
    const {MenuList} = useSelector(state => state.menuReducer);
    
    useEffect( () => {
        /* 메뉴 목록을 조회하는 API를 호출하는 로직을 담은 함수를 전달한다. */
        dispatch(callGetMenuListAPI());
    }, [])
}
export default MenuList;