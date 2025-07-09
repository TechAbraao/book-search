import { Sidenav } from "@/components";

interface LayoutProps {
    children: React.ReactNode;
}

const MainLayout = ({ children }: LayoutProps) => {
    return (
        
        <section className="">
            <Sidenav />
            <aside className="w-full h-2/3 p-18 bg-[#E8E7D5] flex">
                {children}
            </aside>
        </section>
    )
}

const RecommendedBooks = ({ children }: LayoutProps) => {
    return (
        <section className="w-full h-2/3 p-4 bg-[#F9F9F9]">
            {children}
        </section>
    )
}

const BookGenreLayout = ({ children }: LayoutProps) => {
    return (
        <main className="w-full h-screen p-4">
            {children}
        </main>
    )
}

export {
    MainLayout,
    RecommendedBooks,
    BookGenreLayout
}