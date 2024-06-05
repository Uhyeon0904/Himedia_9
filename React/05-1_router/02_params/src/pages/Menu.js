import {useState, useEffect} from 'react';
/* MenuAPI 중에 구조 분해 할당해서 사용하겠다. */
import { getMenuList } from '../api/MenuAPI';
/* module.css: 랜덤으로 클래스 이름을 설정해 준다. */
import boxStyle from './Menu.module.css'
import MenuItem from '../components/MenuItem';
import { useNavigate } from 'react-router-dom';

function Menu() {

    const [menuList, setMenuList] = useState();
    const [searchValue, setSearchValue] = useState('');

    useEffect( () => {
        setMenuList(getMenuList());
    }, []);

    /* useNavigate: 버튼을 클릭 했을 때 url을 변경해준다. */
    const navigate = useNavigate();

    /* 입력한 값으로 검색 */
    const onClickHandler = () => navigate(`/menu/search?menuName=${searchValue}`);

    return(
        <>
            <div>
                <h1>메뉴 목록</h1>
                <div>
                    <input 
                        type='search'
                        name="menuName"
                        value={searchValue}
                        onChange={ e => setSearchValue(e.target.value)}
                    />
                    <button onClick={onClickHandler}>검색</button>
                </div>
                <div className={boxStyle.MenuBox}>
                    {menuList && menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>)}
                </div>
            </div>
        </>
    );
};

export default Menu;