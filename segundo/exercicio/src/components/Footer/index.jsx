//exercicio\src\components\Footer\index.jsx//

import './style.css';

function Footer(){
    return(
        <footer className="footer-admin">
            <p>
                &copy; {new Date().getFullYear} - Armazenamentos de Dados.
                <br />Senai Dendezeiros
                <br />CNPJ: 00.000.000/0001-00
            </p>

        </footer>
        
    )
}

export default Footer;