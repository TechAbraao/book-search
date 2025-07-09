interface ButtonProps {
    text: string;
}

const Button = ({ text = "Default" }: ButtonProps) => {
    return (
        <button className="bg-[#E6C32F] w-66 text-white px-4 py-3
         hover:bg-blue-600 transition duration-300 cursor-pointer">
            { text }
        </button>
    )
}

export { Button };