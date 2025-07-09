import { Button } from "../Buttons/Buttons"


const Sidenav = () => {
    return (
        <nav className="w-full h-20 flex bg-[#E8E7D5]">
            <section className="w-full  flex items-center justify-between pl-18">
                <ul>
                    <li>
                        <a href="#" className="text-[#0A1E33] font-bold cursor-pointer">Início</a>
                    </li>
                </ul>
            </section>
            <section className="flex items-center jus
            tify-center gap-4 w-1/3 pl-6 pr-6">
                <Button text={"Login"}/>
                <Button text={"Registrar-se"}/>
            </section>
        </nav>
    )
}

export {
    Sidenav
}