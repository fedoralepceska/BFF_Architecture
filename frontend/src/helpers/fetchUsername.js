import apiInstance from '../api';

async function fetchUsername() {
    try {
        const response = await apiInstance.get('/api/get-username');
        return response.data;
    } catch (error) {
        console.error('Error fetching username:', error);
        throw error;
    }
}

export default fetchUsername;
