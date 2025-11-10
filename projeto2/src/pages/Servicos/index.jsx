import "./style.css";


export default function Servicos() {
    return (
        <section className="servicos">
            <h1>Serviços da Drogaria</h1>
            <p>Atendemos vocês com toda rapidez e cuidados necessários</p>


            <div className="grid cols-3">
                <div className="card">
                    <h3>Testes Rápidos de Saúde</h3>
                    <p>Cuidar de você é nossa prioridade — faça seus testes rápidos com segurança, praticidade e confiança.</p>
                </div>
                <div className="card">
                    <h3>Dispensação de Medicamentos</h3>
                    <p>Fornecimento de medicamentos acompanhado de informações sobre dosagem, horários, efeitos colaterais e interações, assegurando o uso responsável e seguro.</p>
                </div>
                <div className="card">
                    <h3>Entrega Domiciliar</h3>
                    <p>"Mais cuidado, menos deslocamento."</p>
                </div>
            </div>
        </section>
    );
}