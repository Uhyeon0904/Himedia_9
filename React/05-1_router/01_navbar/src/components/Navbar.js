import {NavLink} from 'react-router-dom';

function Navbar() {
    const activeStyle = {
        backgroundColor: 'orangered'
    };

    return(
        <div>
            <ul>
                <li>
                    <NavLink to='/' style={({isActive}) => isActive ? activeStyle : undefined}>HOME</NavLink>
                </li>
                <li>
                    <NavLink to='/about' style={({isActive}) => isActive ? activeStyle : undefined}>ABOUT</NavLink>
                </li>
                <li>
                    <NavLink to='/menu' style={({isActive}) => isActive ? activeStyle : undefined}>MENU</NavLink>
                </li>
            </ul>
        </div>
    )
}

export default Navbar;