import { BackgroundImage } from "@/components/BackgroundImage";
import { DefaultLayout } from "@/layouts/DefaultLayouts";
import { MainLayout, RecommendedBooks } from "@/layouts/HomePageLayouts";
import { MainText } from "@/components/Texts";

const HomePage = () => {
    return (
        <DefaultLayout>
            <MainLayout>
                <MainText />
                <BackgroundImage />
            </MainLayout>
            <RecommendedBooks>
                <header>
                    <h1 className="text-[#0A1E33] font-bold text-4xl 
                    w-full text-center p-4">Qual gênero deseja?</h1>
                </header>
                <section className="w-full h-1/2 flex flex-col items-center justify-center gap-4 bg-blue-700">
                    
                </section>
                <section className="w-full h-1/2 flex flex-col items-left justify-start gap-4 bg-red-700">
                    <label className="w-1/2 font-bold text-2xl bg-green-400">Sobre o que você gostaria de receber uma recomendação de livro?</label>
                    <input type="text" />
                </section>
            </RecommendedBooks>
        </DefaultLayout>
    );
}

export default HomePage;