import axios from 'axios';

const apiInstance = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Access-Control-Allow-Origin' : '*',
    }

});

export default apiInstance;
