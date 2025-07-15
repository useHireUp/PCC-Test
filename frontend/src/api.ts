import axios from 'axios';

const API_BASE = 'http://localhost:8080';

export const getMedications = async () => {
  const res = await axios.get(`${API_BASE}/medications`);
  return res.data;
};

export const submitRequest = async (payload: { patientId: string, medicationId: string }) => {
  return axios.post(`${API_BASE}/requests`, payload, {
    headers: {
      'x-user-role': 'nurse'
    }
  });
};
