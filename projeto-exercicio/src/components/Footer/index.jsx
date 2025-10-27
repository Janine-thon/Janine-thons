//src\components\Footer\index.jsx//
import { useState } from 'react';
import './style.css';


function Footer() {
  return (
    <footer className="footer-container">
      <p>&copy; {new Date().getFullYear()} - Todos os direitos reservados.
        <br />Senai Dendezeiros
        <br />CNPJ: 00.000.000/0001-00
      </p>
    </footer>
  );
}

export default Footer

