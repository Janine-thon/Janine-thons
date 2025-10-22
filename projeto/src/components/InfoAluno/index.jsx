// projeto\src\components\InfoAluno\index.jsx
import {useState} from 'react';
import './style.css'

function InfoAluno(){
   // const nome="Janine Vandy";
    //const idade=22;
    //const curso="Desenvolvimento de Sistemas";

    // Hook useState
    const [nome, setNome] = useState("Janine Vandy");
    const [idade, setIdade] = useState("22");
    const [curso, setCurso] = useState("Desenvolvimento de Sistemas");

    return(
        <div className="info-aluno">
            <h2>Informações do Aluno</h2>
            <p>Nome: {nome}</p>
            <p>Idade: {idade}</p>
            <p>Curso: {curso}</p>
        </div>
    );
}

export default InfoAluno;