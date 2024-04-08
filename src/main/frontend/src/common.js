import React, {useEffect, useState} from 'react';


const Common = () => {
    const [data, setData] = useState('');

    const [responseData, setResponseData] = useState('');

    const fetchData = async () => {
      try {
        const response = await fetch('/welcome');
        const data = await response.text();
        console.log('Received data from server:', data);
  
        // 서버로부터 받은 데이터를 상태로 설정
        setResponseData(data);
  
        // 필요에 따라 추가적인 처리를 수행할 수 있습니다.
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
  
    const handleButtonClick = () => {
      // 클릭 이벤트가 발생하면 서버로부터 데이터를 다시 요청
      fetchData();
    };

    const sendData = async () => {
      try {
        const response = await fetch('/common', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ yourData: data }),
        });
        
        // 서버로부터 응답을 처리하거나 확인합니다.
        const responseData = await response.json();
        console.log(responseData);
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
      <button onClick={handleButtonClick}>데이터 받기 </button>
      <div>
        {/* 서버로부터 받은 데이터를 출력 */}
        {responseData && <p>Received Data: {responseData}</p>}
      </div>

        </>
    );
};

export default Common;