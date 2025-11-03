//src\components\Header\index.jsx//

import { Link, NavLink } from 'react-router-dom'
import logo from '../../assets/logo.png'
import './style.css'

export default function Header() {
    return(
        <header className="header">
            <div className='header__'>
                <Link to=''>
                <img src={logo} alt="Logo da Contabilidade" />
                <span>Contabilidade Dendezeiros</span>
                </Link>
            </div>
            <nav className='nav'>
                <NavLink to='/sobre-nos'>Sobre nós</NavLink>
                <NavLink to='/fale-conosco'>Contato</NavLink>
            </nav>
        </header>
    )
}