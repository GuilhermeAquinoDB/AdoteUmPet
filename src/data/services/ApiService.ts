import axios from 'axios';

export const ApiService = axios.create({
    baseURL: 'https://adocao-pet.herokuapp.com/api',
    headers: {
      'Content-Type': 'application/json'
    }
})