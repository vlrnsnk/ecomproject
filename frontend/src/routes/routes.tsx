import { createBrowserRouter } from 'react-router-dom';
import { Layout } from '../components/layout/Layout/Layout';
import { HomePage } from '../pages/public/HomePage/HomePage';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Layout />,
    children: [
      { path: '/', element: <HomePage /> },
    ],
  },
]);

export { router };
