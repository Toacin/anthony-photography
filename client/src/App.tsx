import React from 'react';
import './App.css';
import { Route, HashRouter, Routes } from 'react-router-dom';
import { Hash } from 'crypto';
import Homepage from './Pages/Homepage';

function App() {
  return (
    <HashRouter>
      <Routes>
        <Route path="/" element={<Homepage/>}/>
      </Routes>
    </HashRouter>
  );
}

export default App;