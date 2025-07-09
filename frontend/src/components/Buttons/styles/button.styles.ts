interface ButtonStyles {
  primaryButton: string;
}

export const styles: ButtonStyles = {
  primaryButton: `
    bg-[#E6C32F] w-[220px] text-white h-[60px] text-xl px-2 py-2
    hover:bg-transparent hover:border-2 hover:text-[#E6C32F] hover:border-[#E6C32F]
    transition duration-300 cursor-pointer
  `.trim()
}
