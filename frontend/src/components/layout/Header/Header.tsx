import Logo from '@/assets/logo.svg?react';
import { Link } from 'react-router-dom';

const Header: React.FC = () => {
  return (
    <header>
      <div>
        <Link to="/">
          <Logo aria-label="Home Page" width="48" height="48" />
          <span>
            E-Commerce App
          </span>
        </Link>
        <nav>
          <Link to="/login" aria-label="Login Page">
            Login
          </Link>
          <Link to="/register" aria-label="Register Page">
            Register
          </Link>
        </nav>
      </div>
    </header>
  );
};

export { Header };
