import React, { useState } from "react";
import './css/Join.css';
import axios from "axios";


//import axiosInstance from "/axiosInstance";
import './css/Join.css';

const Join = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');


    const [idMessage, setIdMessage] = useState('');
    const [usernameReadOnly, setUsernameReadOnly] = useState(false);

    const checkId = () => {

        if(!username) {
            alert("아이디를 입력해주세요.");
            return;
        }
        const requestData = {
            username: username
        };

        axios.post('/checkid', requestData)
            .then((res) => {
                const checkid = res.data;

                console.log('checkId() 서버로부터 응답 : ', checkid);
                if (checkid === "T") {
                    setIdMessage("사용 가능한 아이디입니다.");
                    setUsernameReadOnly(true);
                } else if (checkid === "F") {
                    setIdMessage("중복된 아이디입니다.");
                    setUsernameReadOnly(false);
                } else {
                    console.log('Error: ', checkid);
                    setUsernameReadOnly(false);
                }
            })
            .catch((error) => {
                console.error('Error checking ID:', error);
            });
    };

    const handleSignUp = () => {
        // 필수 입력 필드가 비어 있는지 확인
        if (!username || !password || !confirmPassword || !email || !phone) {
            alert("모든 필수 입력 필드를 작성해주세요.");
            return;
        }

        // 이메일 유효성 검사 (간단한 형식 확인)
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailPattern.test(email)) {
            alert("올바른 이메일 주소를 입력해주세요.");
            return;
        }

        // 전화번호 유효성 검사 (간단한 형식 확인)
        const phonePattern = /^\d{3}-\d{3,4}-\d{4}$/;
        if (!phonePattern.test(phone)) {
            alert("올바른 전화번호를 입력해주세요. (예: 010-1234-5678)");
            return;
        }

        // 비밀번호 일치 확인
        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }

        // 여기서 회원가입 로직을 진행
        console.log('회원가입 성공!');
    };

    return (
        <div className="Sign">
            <nav>
                <ul>
                    <li><a href="#">HOME</a></li>
                </ul>
            </nav>
            <div className="signup-box">
                <h2 className="signup">회원가입</h2>
                <form action="/joinProc" method="get" name="joinForm">
                    <div className="input-group">
                        <input
                            type="text"
                            name="username"
                            placeholder="아이디"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            readOnly={usernameReadOnly}
                        />
                        <button type="button" onClick={checkId}>중복확인</button>
                        <div>아이디 메시지 : {idMessage}</div>
                        <input
                            type="password"
                            name="password"
                            placeholder="비밀번호"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                        <input
                            type="password"
                            placeholder="비밀번호 확인"
                            value={confirmPassword}
                            onChange={(e) => setConfirmPassword(e.target.value)}
                        />
                        <input
                            type="text"
                            placeholder="이메일"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                        <input
                            type="text"
                            placeholder="전화번호"
                            value={phone}
                            onChange={(e) => setPhone(e.target.value)}
                        />
                    </div>
                    <div className="button-group">
                        <button type="submit" onClick={handleSignUp}>회원가입</button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default Join;

