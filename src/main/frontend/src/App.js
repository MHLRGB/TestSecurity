import React, {useEffect, useState} from 'react';
import { Route, Routes } from 'react-router-dom';
import Login from './login.js';
import Join from './join.js';
import Test from './test.js';
import Admin from './adimn.js';


const App = () => {
    return (
        <div>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/join" element={<Join />} />
                <Route path="/test" element={<Test />} />
                <Route path="/admin" element={<Admin />} />
                <Route path="/"/>
            </Routes>
        </div>
    );
};

export default App;