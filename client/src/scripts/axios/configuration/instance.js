import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://127.0.0.1:8080',
    timeout: 10000,
    headers: {
        'Content-Type': 'application/json',
    },
});

const post = function post(url, data) {
    return instance.post(url, data);
};

const get = function get(url) {
    return instance.get(url);
};
export {instance, post, get};
