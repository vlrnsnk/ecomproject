import { Button } from '@/components/ui/Button/Button';
import { PageWrapper } from '@/components/layout/PageWrapper/PageWrapper';
import Logo from '@/assets/logo.svg?react';

const HomePage: React.FC = () => {
  return (
    <PageWrapper>
      <header className="mb-12">
        <Logo aria-label="Home Page" width="48" height="48" />
        <h1>E-Commerce App</h1>
        <p>Shop with ease!</p>
      </header>
      <div className="flex justify-center">
        <Button>Login</Button>
        <Button>Register</Button>
      </div>
    </PageWrapper>
  );
};

export { HomePage };
