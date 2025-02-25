import { UserResponse } from '@/interfaces/user';
import { api } from './api';

const getUsers = async (): Promise<UserResponse[]> => {
  try {
    const response = await api.get<UserResponse[]>('/users');

    return response.data;
  } catch (error) {
    console.error('Error fetching users:', error);

    throw new Error('Failed to fetch users. Please try again later.');
  }
};

export {
  getUsers,
};
