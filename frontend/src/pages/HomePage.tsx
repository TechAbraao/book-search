import { BackgroundImage } from "@/components";
import { DefaultLayout } from "@/layouts/DefaultLayouts";
import { MainLayout, RecommendedBooks } from "@/layouts/HomePageLayouts";
import { MainText } from "@/components/Texts/Texts";

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
                <section className="w-full p-10 flex flex-col items-left justify-center gap-4">
                    <label className="w-1/2 font-bold text-2xl text-[#0A1E33]">Sobre o que você gostaria de receber uma recomendação de livro?</label>
                    <input type="text" placeholder="Qual livro deseja pesquisar?" className="bg-white rounded text-gray-800 p-3 w-3/4 border-2 placeholder-gray-800"/>
                </section>
            </RecommendedBooks>
        </DefaultLayout>
    );
}

export default HomePage;