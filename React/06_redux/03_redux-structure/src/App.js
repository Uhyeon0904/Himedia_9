import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Layout from './components/layouts/Layout';
import Main from './pages/Main';
import Menus from './pages/Menus'

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Layout/>}>
            <Route index element={<Main/>}/>
            <Route path='menu'>
              <Route index element={<Menus/>}/>
            </Route>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
