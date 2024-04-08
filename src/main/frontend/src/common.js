import React, {useEffect, useState} from 'react';
import axios from 'axios';

const Common = () => {
    const [data, setData] = useState('');

    const [responseData, setResponseData] = useState();

    const requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };

    // const fetchData = async () => {
    //   try {
    //     const response = await fetch('/common');
    //     const data = await response.text();
    //     console.log('Received data from server:', data);
  
    //     // 서버로부터 받은 데이터를 상태로 설정
    //     setResponseData(data);
  
    //     // 필요에 따라 추가적인 처리를 수행할 수 있습니다.
    //   } catch (error) {
    //     console.error('Error fetching data:', error);
    //   }
    // };
    const fetchData = async () => {
      axios
      .get("/welcome")
      .then((res) => {
        console.log('fetchData 함수:', res.data);
        setResponseData(JSON.stringify(res.data));
      })
      .catch((err) => {
          console.log(err);
      });
    };

    
    const sendData = async () => {
      try {
        const response = await axios.post('/common', { data }, {
          headers: {
            'Content-Type': 'application/json'
          }
        });
    
        // 서버로부터 응답을 처리하거나 확인합니다.
        console.log('sendData 함수:', response.data);
      } catch (error) {
        console.error('Error:', error);
      }
    };


    return (
        <>
        <h2>Common.js입니다.</h2>
        <input
        type="text"
        value={data}
        onChange={(e) => setData(e.target.value)}
      />
      <button onClick={sendData}>데이터 보내기</button>
      <br />
      <button onClick={fetchData}>데이터 받기 </button>
      <div>
        <p>Received Data: {responseData}</p>
      </div>

        </>
    );
};

export default Common;