import {Link} from 'react-router-dom';

function Main() {
    return(
        <>
            <div>
                <h1>메인</h1>
                <nav>
                    {/* Link: 라우터에서 제공하는 경로 이동 돔 */}
                    {/* to: 요청 주소 */}
                    <Link to="/">HOME</Link>
                    <Link to="/about">소개</Link>
                    <Link to="/menu">메뉴 목록</Link>
                </nav>
            </div>
        </>
    );
};

export default Main;