import React, { useState } from "react";
//import axiosInstance from "/axiosInstance";

const Join = () => {
    const [joininInput, setJoinInput] = useState({
        userId: "",
        password: "",
    });

    return (
        <>
        <h2>Join.js입니다.</h2>
        <form action="/joinProc" method="get" name="joinForm">
            <input type="text" name="username" placeholder="Username"/>
            <input type="password" name="password" placeholder="Password"/>
            <input type="submit" value="Join"/>
        </form>
        </>
    );
};

export default Join;