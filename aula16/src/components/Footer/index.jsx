//src\components\Footer\index.jsx//

export  default  function Footer() {
    return(
        <footer className="footer">
            <div>
                <strong>Contabilidade Simples</strong>
                <br />
                CNPJ - 00.000.000/0001-00
            </div>
            <div>
                Rua A, 123 - Centro - Salvador - Bahia
            </div>
            <div className='copy'>
                &copy; {new Date().getFullYear()} Todos os direitos reservados.
            </div>
        </footer>
    )
}