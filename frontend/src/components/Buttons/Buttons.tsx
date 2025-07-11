'use client'
import { useRouter } from 'next/navigation'
import { styles } from "./styles/button.styles";

interface ButtonProps {
  text?: string
  href?: string
}

const Button = ({ text = "Default", href = "/" }: ButtonProps) => {
  const router = useRouter()
  const handleClick = () => {
    if (href) { router.push(href) }
  }

  return (<button onClick={handleClick} className={styles.secondaryButton}>{text}</button>)
}

const GenderButton = ({ text = "Default" }: ButtonProps) => {
    return (<button className={styles.primaryButton}>{text}</button>);
};


export { Button, GenderButton };