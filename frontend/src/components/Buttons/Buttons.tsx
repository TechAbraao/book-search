'use client'
import { useRouter } from 'next/navigation'
import { styles } from "./styles/button.styles";

type ButtonProps = {
  text?: string;
  href?: string;
  button_type?: "button" | "submit" | "reset";
  redirect?: boolean;
};

const Button = ({ text = "Default", href = "/", button_type = "button", redirect = false }: ButtonProps) => {
  const router = useRouter();

  const handleClick = () => {
    if (redirect === true && href) {
      router.push(href);
    }
  };

  return (
    <button onClick={handleClick} type={button_type} className={styles.secondaryButton}>
      {text}
    </button>
  );
};

const GenderButton = ({ text = "Default" }: ButtonProps) => {
    return (<button className={styles.primaryButton}>{text}</button>);
};


export { Button, GenderButton };