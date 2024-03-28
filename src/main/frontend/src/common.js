import React, {useEffect, useState} from 'react';


const Common = () => {
    const [data, setData] = useState('');

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
      <input
        type="text"
        value={data}
        onChange={(e) => setData(e.target.value)}
      />
      <button onClick={sendData}>Send Data</button>
        </>
    );
};

export default Common;