import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';

import api from '../../services/api';
import { toast } from 'react-toastify'

import './style.css';


const esquemaDeCadastro = yup.object({
    nome: yup.string()
        .required('O nome é obrigatório')
        .min(3, 'O nome deve ter pelo menos 3 caracteres'),
    email: yup
        .string()
        .email('Formato de e-mail inválido')
        .required('O e-mail é obrigatório'), senha: yup
            .string()
            .min(3, 'A senha deve ter pelo menos 3 caracteres')
            .required('A senha é obrigatória'),
    confirmarSenha: yup
        .string()
        .oneOf([yup.ref('senha'), null], 'As senhas devem ser iguais')
        .required('A confirmação de senha é obrigatória'),
})

export default function CadastroPage() {
    const {
        register: registrarCampo,
        handleSubmit: lidarComEnvioDoFormulario,
        formsState: { errors: errosDoFormulario, isSUbmitting: estaEnviando },
        setError: definirErroNoCampo,
        reset: limparCamposDoFormulario,
    } = useForm({
        resolver: yupResolver(esquemaDeCadastro),
        defaultValues: {
            nome: '',
            email: '',
            senha: '',
            confirmarSenha: '',
        },
    });

    async function enviarDados(dadosDoFormulario) {
        const dadosApi = {
            nome: dadosDoFormulario.nome,
            email: dadosDoFormulario.email,
            senha: dadosDoFormulario.senha,
        };

        try {
            const resposta = await api.post('/usuários', dadosApi);
            toast.success(resposta.data.mensagem || 'Cadastro realizado com sucesso!');
            limparCamposDoFormulario();
        } catch (erro) {
            const codigoDeStatus = erro.response?.status;
            const mensagemErro = erro.response?.data?.mensagem || 'Erro ao cadastrar seu usuário.';
            if (codigoDeStatus === 409) {
                definirErroNoCampo('email', {
                    type: 'server',
                    message: mensagemDoServidor,
                });
            }
            toast.error(mensagemDoServidor);
            console.error('Erro ao cadastrar usuário:', erro);
        }
    }

    return (
        <>
            <div className="cadastro - container">
                <h1>Cadastro de Usuários</h1>
                <form noValidate onSubmit={lidarComEnvioDoFormulario(enviarDados)}>
                    {/* Nome */}
                    <div className='form-group'>
                        <label htmlFor="campo-nome">Nome:</label>
                        <input
                            type="text"
                            id="campo-nome"
                            placeholder='Ex.: Maria Silva'
                            {...registrarCampo('nome')}
                        />
                    </div>
                    {errosDoFormulario.nome && (
                        <span className="error">{errosDoFormulario.nome.message}</span>
                    )}
                    <button type="submit" disabled={estaEnviando}>
                        {estaEnviando ? 'Cadastrando...' : 'Cadastrar'}
                    </button>
                </form>
            </div>
        </>
    );
}