import axios from "axios";

const API_URL = "http://localhost:8080/api";

export const registerUser = async (userData: {
    username: string;
    email: string;
    password: string;
    confirmPassword: string;
}) => {
    const response = await axios.post(`${API_URL}/users`, userData);
    return response.data;
};
