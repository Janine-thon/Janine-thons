import "./style.css";


export default function Footer() {
    return (
        <footer className="footer">
            <div className="footer__wrap">
                <div>
                    <strong>Drogaria Lobo</strong> — CNPJ 01.324.206/0001-55
                </div>
                <div>
                    Rua Doutor Francisco Bandeira Rolim, 34 — Bonocô — Salvador/BA • (71) 34550077 • drogarialobo44@gmail.com
                </div>
                <div className="copy">© {new Date().getFullYear()} Todos os direitos reservados.</div>
            </div>
        </footer>
    );
}