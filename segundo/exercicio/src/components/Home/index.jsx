//exercicio\src\components\Home\index.jsx//

import React, { useState } from 'react';
import './style.css';

function Home(){
    const[nome, setNome] = useState ('' );
    const[telefone, setTelefone] = useState ('' );

    const [usuarios, setUsuarios] = useState([]);

    const handleSubmit = (event) =>{
         event.preventDefault();
        if (nome && telefone) {
            setUsuarios([...usuarios, { nome, telefone }]);
            setNome('');
            setTelefone('');
        }
    }

    return(
        <div className="central">
            <div className='container'>
                <h2>Cadastro de Funcionários</h2>
                <form onSubmit={handleSubmit}>
                    <input 
                    type="text"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                    />
                      <input 
                    type="telefone"
                    placeholder="Telefone"
                    value={telefone}
                    onChange={(e) => setNome(e.target.value)}
                    />
                    <button type="submit">Adicionar</button>
                </form>
                <h3>Funcionários Adicionados</h3>
                <ul>
                    {usuarios.map((usuario, index) => (
                        <li key={index}>
                            {usuario.nome} - {usuario.telefone}
                        </li>
                    ))}
                  </ul>
            </div>
        </div>
    )
}

export default Home;