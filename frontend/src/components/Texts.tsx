import { Button } from "@/components/Buttons";

const MainText = () => {
    return <section className="w-1/2 h-full flex flex-col items-left justify-center text-[#0A1E33] font-bold gap-6">
        <header className="flex flex-col items-left justify-center gap-3">
            <h1 className="text-6xl text-left w-3/4 leading-[1.1]">
                <span className="bg-[#E6C32F] p-1">Descubra</span> sua próxima leitura!
            </h1>
            <p className="font-extralight w-3/4">Utilizar o Book Search como sua principal plataforma de pesquisa de livros oferece resultados rápidos e precisos, otimizando a experiência e satisfação do usuário.</p>
        </header>
        <Button text={"Pesquisar"}/>
    </section>
}

export {
    MainText
};