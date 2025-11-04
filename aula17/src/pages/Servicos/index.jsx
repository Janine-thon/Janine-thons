import "./style.css";


export default function Servicos() {
    return (
        <section className="servicos">
            <h1>Serviços de Contabilidade</h1>
            <p>Atendemos empresas de todos os portes com pacotes sob medida.</p>


            <div className="grid cols-3">
                <div className="card">
                    <h3>Abertura de empresa</h3>
                    <p>Do zero à regularização: CNAE, contrato social e inscrição.</p>
                </div>
                <div className="card">
                    <h3>Fiscal & Tributário</h3>
                    <p>Apuração de impostos, emissão de guias e obrigações acessórias.</p>
                </div>
                <div className="card">
                    <h3>Folha de pagamento</h3>
                    <p>Admissões, férias, rescisões e eSocial organizados e sem dor de cabeça.</p>
                </div>
            </div>
        </section>
    );
}