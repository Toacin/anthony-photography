import React from 'react';
import './App.css';
import { Route, HashRouter, Routes } from 'react-router-dom';
import AdminPage from './Pages/AdminPage';
import Homepage from './Pages/Homepage';

function App() {
  return (
    <HashRouter>
      <Routes>
        <Route path="/" element={<Homepage/>}/>
        <Route path='/admin/*' element={<AdminPage/>}/>
      </Routes>
    </HashRouter>
  );
}

export default App;