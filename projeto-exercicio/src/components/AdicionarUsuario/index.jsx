//src\components\AdicionarUsuario\index.jsx//

import React, {useState} from 'react';
import './style.css';

function AdicionarUsuario(){
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');

    const [usuarios, setUsuarios] = useState([]);

    const handleSubmit = (event) => {
        event.preventDefault();
        if(nome && email){
            setUsuarios([...usuarios,{nome, email}]);
            setNome('');
            setEmail('');
        }
    }


    return(
       <div className="central">
           <div className='container'>
            <h2>Adicionar Usuário</h2>
            <form onSubmit={handleSubmit}>
                <input 
                    type="text" 
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                />
                <input 
                    type="email" 
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
                <button type="submit">Adicionar</button>
            </form>
            <h3>Usuários Adicionados</h3>
            <ul>
                {usuarios.map((usuario, index) => (
                    <li key={index}>
                        {usuario.nome} - {usuario.email}
                    </li>
                ))}
            </ul>
              </div>
       </div>
    )
}

export default AdicionarUsuario;