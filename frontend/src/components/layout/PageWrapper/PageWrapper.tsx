import { PageWrapperProps } from '@/interfaces/PageWrapperProps';

const PageWrapper: React.FC<PageWrapperProps> = ({ children }) => {
  return (
    <div className="flex flex-col items-center">
      <section>
        {children}
      </section>
    </div>
  );
};

export { PageWrapper };
