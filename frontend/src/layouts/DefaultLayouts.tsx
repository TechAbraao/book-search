interface LayoutProps {
  children: React.ReactNode;
}

const DefaultLayout = ({ children }: LayoutProps) => {
  return (
    <main className="w-full h-screen bg-white">
      {children}
    </main>
  );
};

export { DefaultLayout };