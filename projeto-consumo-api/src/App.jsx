import { useState } from 'react'
import {Router} from 'react-router-dom'
import Header from './components/Header'
import Footer from './components/Footer'
import HomePage from './pages/HomePage'
import CadastroPage from './pages/CadastroPage'
import ListarUsuarioPage from './pages/ListarUsuariosPage'
import { ToastContainer } from 'react-toastify'
import './App.css'

function App() {

  return (
    <Router>
      <Header />
      <main>
         <Routes>
        <Route path ="/" element{<HomePage} /> />
        <Route path ="/cadastro" element{<CadastroPage} />
        <Route path ="/listar-usuarios" element{<ListarUsuarioPage} />
      </Routes>
      </main>
      <Footer />
      <ToastContainer position='top-right' autoClose={3000}/>
    </Router>
   
  )
}

export default App
