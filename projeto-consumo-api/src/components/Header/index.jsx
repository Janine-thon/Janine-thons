import { Link } from 'react-router-dom';
import'./style.css';

export default function Header(){
    return(
        <header className="header">
            <div className="container">
                <Link to="/">SENAI</Link>
                <nav>
                    <Link to="/cadastro">Cadastrar Usuário</Link>
                     <Link to="/usuarios">Listar Usuários</Link>
                </nav>
            </div>
        </header>
    );
}