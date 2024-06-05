import {useSearchParams} from 'react-router-dom';
import {useState, useEffect} from 'react';
import { getSearchMenu } from '../api/MenuAPI';
import boxStyle from './Menu.module.css';
import MenuItem from '../components/MenuItem';

function MenuSearchResult() {

    /* useSearchParams: 배열로 꺼내온다. 구조 분해 할당*/
    /* 쿼리 스트링 형태로 전달 된 값은 useSearchParams hook을 통해 꺼낼 수 있다. */
    const [searchParams] = useSearchParams();

    /* 쿼리 스트링의 키 값을 get 함수에 전달하여 해당 파라미터 값을 읽어온다. 
    * menuName의 key를 보낸다. */
    const menuName = searchParams.get('menuName');

    /* 메뉴 목록을 관리할 state */
    const [menuList, setMenuList] = useState();

    useEffect( () => {
        /* 검색한 메뉴 이름을 getSearchMenu로 보낸 후 set 한다. */
        setMenuList(getSearchMenu(menuName));
    }, [])

    /* 입력 값이 잘 넘어온다. */
    console.log(menuName)

    return (
        <>
            <h1>메뉴 검색 결과</h1>
            <div className={boxStyle.MenuBox}>
                {menuList && menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>)}
            </div>
        </>
    )
}

export default MenuSearchResult;