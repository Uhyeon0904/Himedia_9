import {useParams} from 'react-router-dom';
import {useState, useEffect} from 'react';
import { getMenuDetail } from '../api/MenuAPI';

function MenuDetails() {
    /* useParams: react-router-dom의 userParams라는 hook을 이용하여 path vaiable을 읽어올 수 있다.
    * 구조 분해 할당하는 이름은 <Route>에 설정한 ":menuCode"로 설정 되어야 한다. */
    const {menuCode} = useParams();
    const [menu, setMenu] = useState();

    useEffect( () => {
        setMenu(getMenuDetail(menuCode));
    }, []);

    console.log(menuCode);

    return(
        menu &&
        <>
            <h2>메뉴 상세 페이지</h2>
            <h2>{`메뉴 이름 : ${menu.menuName}`}</h2>
            <h2>{`메뉴 가격 : ${menu.menuPrice}`}</h2>
            <h2>{`메뉴 종류 : ${menu.categoryName}`}</h2>
            <h2>{`메뉴 설명 : ${menu.detail.description}`}</h2>
            <img src={menu.detail.image} style={{maxWidth:500}} alt={menu.menuName}/>
        </>
    );
};

export default MenuDetails;