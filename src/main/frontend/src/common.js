import React, {useEffect, useState} from 'react';


const Common = () => {

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