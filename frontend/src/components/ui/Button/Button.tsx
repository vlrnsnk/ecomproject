interface ButtonProps {
  children: React.ReactNode;
  handleClick?: () => void;
  isActive?: boolean;
  type?: 'button' | 'submit' | 'reset';
};

const Button: React.FC<ButtonProps> = ({
  children,
  handleClick,
  isActive = true,
  type,
}) => {

  return (
    <button
        onClick={handleClick}
        disabled={!isActive}
        type={type}
      >
      {children}
    </button>
  );
};

export { Button };
