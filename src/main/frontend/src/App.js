import React, {useEffect, useState} from 'react';
import { Route, Routes } from 'react-router-dom';
import Login from './login.js';
import Join from './join.js';
import Test from './test.js';
import Admin from './adimn.js';
import Main from './main.js';
import Common from './common.js';
import axios from 'axios';

const App = () => {
    return (
        <div>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/join" element={<Join />} />
                <Route path="/test" element={<Test />} />
                <Route path="/admin" element={<Admin />} />
                <Route path="/common" element={<Common />} />
                <Route path="/" element={<Main />}/>
            </Routes>
        </div>
    );
};

export default App;