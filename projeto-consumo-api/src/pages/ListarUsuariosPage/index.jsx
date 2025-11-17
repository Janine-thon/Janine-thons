import { useEffect, useState } from 'react';
import api from '../../services/api';
import { toast } from 'react-toastify'
import './style.css';

export default function ListarUsuarioPage() {
    const [usuarios, setUsuarios] = useState([]);
    const [carregando, setCarregando] = useState(true);

    useEffect(() => {
        async function buscarUsuarios() {
            try {
                const resposta = await api.get('/usuários');
                setUsuarios(resposta.data);
            } catch (erro) {
                console.error('Erro ao buscar usuários:', erro);
                const mensagemDeErro = erro.response?.data?.mensagem || 'Erro ao buscar usuários.';
                toast.error(mensagemDeErro);
            } finally {
                setCarregando(false);
            }
        }
        buscarUsuarios();
    }, []);

    if (carregando) {
        return <div>Carregando ...</div>;
    }

    return (
        <div className="listar-usuarios-container">
            <h1>Lista de Usuários</h1>
            {usuarios.length === 0 ? (
                <p>Nenhum usuário encontrado.</p>
            ) : (
                <ul>
                    {usuarios.map((usuario) => (
                        <li key={usuario.id}>{usuario.nome}</li>
                    ))}
                </ul>
            )}
        </div>
    );
}