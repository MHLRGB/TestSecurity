import React, {useEffect, useState} from 'react';
import axios from "axios";
import { Route, Routes } from 'react-router-dom';
//import axiosInstance from "/axiosInstance";

const Test = () => {

    const [hello, setHello] = useState('');

    useEffect(() => {
        axios.get('/login')
            .then((res) => {
                setHello(res.data);
            })
    }, []);

    return (
        <>
        <h2>Test.js입니다.</h2>
        <div>백엔드 데이터 : {hello}</div>
        </>
    );
};

export default Test;