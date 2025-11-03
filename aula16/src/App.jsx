
import './App.css'
import Footer from './components/Footer'
import Header from './components/Header'
import { Routes, Route } from 'react-router-dom'
import SobreNosPage from './pages/SobreNosPage'
function App() {


  return (
    <>
    <Header />
    <main>
      <Routes>
        <Route path='/' element={<Homepage/>} />
        <Route path='/sobre-nos' element={<SobreNosPage/>} />
      </Routes>
      </main>
      <Footer />
    </>
  )
}

export default App
