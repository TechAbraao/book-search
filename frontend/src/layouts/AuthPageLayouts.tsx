
interface AuthPageLayoutProps {
    children: React.ReactNode;
};

const LoginLayout = ({ children }: AuthPageLayoutProps) => {
    return (
        <section className="w-full h-screen p-4 bg-[#E8E7D5] flex items-center justify-center">
            {children}
        </section>
    );
};

const RegisterLayout = ({ children }: AuthPageLayoutProps) => {
    return (
        <section className="w-full h-screen p-4 bg-[#E8E7D5] flex items-center justify-center">
            {children}
        </section>
    );
};


export { LoginLayout, RegisterLayout };