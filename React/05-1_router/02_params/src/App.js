import { BrowserRouter, Route, Routes } from "react-router-dom";
import Layout from "./layouts/Layout";
import Main from "./pages/Main";
import About from "./pages/About";
import Menu from "./pages/Menu";
import MenuDetails from "./pages/MenuDetails";
import MenuSearchResult from "./pages/MenuSearchResult"
import Error from "./pages/Error"

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* 루트 요청이 있을 시 Layout 컴포넌트로 렌더링한다. */}
        <Route path="/" element={<Layout/>}>
          <Route index element={<Main/>}/>
          <Route path="about" element={<About/>}/>
          <Route path="menu">
            <Route index element={<Menu/>}/>
            <Route path=":menuCode" element={<MenuDetails/>}/>
            <Route path="search" element={<MenuSearchResult/>}/>
          </Route>
        </Route>
        {/* url 잘못 된 요청이 들어올 경우 */}
        <Route path="*" element={<Error/>}/> 
      </Routes>
    </BrowserRouter>
  );
}

export default App;
