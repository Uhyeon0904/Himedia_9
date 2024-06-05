import Header from "../components/Header";
import Navbar from "../components/Navbar";
import {Outlet} from 'react-router-dom';

function Layout() {
    /* Outlet: 라우팅 되는 컴포넌트를 대체하기 위한 마커의 역할
    header, nav 등 공통적으로 역할을 수행하는 영역은 layout에 위치를 지정하고
    outlet으로 라우팅 될 컴포넌트를 대체하기 위해 표기해두면 해당 영역만 라우팅 시 변경 된다. */
    return(
        <>
            <Header/>
            <Navbar/>
            <Outlet/>
        </>
    )
}

export default Layout;