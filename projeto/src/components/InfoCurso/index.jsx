//projeto\src\components\InfoCurso\index.jsx

// Dados do curso:
//Nome:
//Carga Horária:
//Local:
//Data início:
//Data término:
import {useState} from 'react';
import './style.css';

function InfoCurso(){
    const [Nome, setNomeCurso] = useState("Desenvolvimento de Sistemas");
    const [CargaHoraria, setCargaHoraria] = useState("1600 horas");
    const [Local, setLocalCurso] = useState("Senai - Dendezeiros");
    const [DataInicio, setDataInicio] = useState("01/08/2022");
    const [DataTermino, setDataTermino] = useState("31/07/2024");
    return (
        <div className="info-curso">
            <h2>Informações do Curso</h2>
            <p>Nome: {Nome}</p>
            <p>Carga Horária: {CargaHoraria}</p>
            <p>Local: {Local}</p>
            <p>Data início: {DataInicio}</p>
            <p>Data término: {DataTermino}</p>
        </div>
    );
}

export default InfoCurso;