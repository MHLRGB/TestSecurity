import React, {useEffect, useState} from 'react';
import axios from "axios";

const Main = () => {
    const [auth, setAuth] = useState('');

    useEffect(() => {
        axios.post('/login')
            .then((res) => {
                setAuth(res.data);
            })
    }, []);
    return (
        <>
        <h2>Main.js입니다.</h2>
        <div>접속중인 사용자 정보 : {auth}</div>
        </>
    );
};

export default Main;