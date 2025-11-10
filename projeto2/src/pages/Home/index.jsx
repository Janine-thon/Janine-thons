import { Link } from "react-router-dom";
import "./style.css";
import imagem2 from "../../assets/imagem2.png";
import foto2 from "../../assets/foto2.png";


export default function Home() {
    return (
        <div className="home">
            {/* logo / Landing */}
            <section className="logo">
                <div className="logo__text">
                    <h1>Aqui na Farmácia, seu bem-estar vem em primeiro lugar.</h1>
                    <p>Cuidar da sua saúde é a nossa missão,confiança e cuidado em cada atendimento.</p>
                    <div className="logo__cta">
                        <Link to="/servicos" className="btn primary">Conheça nossos serviços</Link>
                        <Link to="/fale-conosco" className="btn">Fale com um especialista</Link>
                    </div>
                </div>
                <div className="logo__image">
                    <img src={foto2} alt="Equipe de contabilidade" />
                </div>
            </section>


            {/* Destaques / benefícios */}
            <section className="features">
                <h2>Por que nos escolher?</h2>
                <div className="grid cols-3">
                    <div className="card">
                        <h3>Atendimento próximo</h3>
                        <p>Suporte rápido por WhatsApp, e-mail e ligação sempre que precisar.</p>
                    </div>
                    <div className="card">
                        <h3>Profissionais qualificados</h3>
                        <p>Contamos com farmacêuticos capacitados e atualizados para orientar sobre o uso correto dos medicamentos e cuidados com a saúde.</p>
                    </div>
                    <div className="card">
                        <h3>Preços acessíveis e promoções especiais
 </h3>
                        <p>Trabalhamos com os melhores preços e condições para cuidar da sua saúde sem pesar no bolso.</p>
                    </div>
                </div>
            </section>


            {/* Prova social simples */}
            <section className="socialProof">
                <div className="socialProof__image">
                    <img src={imagem2} alt="Escritório da empresa" />
                </div>
                <div className="socialProof__text">
                    <h2>Mais de 200mil pessoas atendidas</h2>
                    <p>Atendimento de qualidade para todas as pessoas de Salvador e região.</p>
                </div>
            </section>
        </div>
    );
}