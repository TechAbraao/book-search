'use client'

import { useState } from "react";
import { registerUser } from "@/services/user.service";

const LoginForm = () => {
    return (
        <form>
            LOGIN
        </form>
    )
}

const RegisterForm = () => {
    const [form, setForm] = useState({
        username: "",
        email: "",
        password: "",
        confirmPassword: ""
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const data = await registerUser(form)
            console.log("Cadastro feito com sucesso!", data);
        } catch (error) {
            console.error("Erro ao cadastrar:", error);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="flex flex-col gap-4 p-10 bg-[#F9F9F9] max-w-md w-full rounded-lg shadow-md">
            <div className="flex flex-col">
                <label htmlFor="username" className="text-[#0A1E33] font-semibold mb-1">
                    Usuário
                </label>
                <input
                    id="username"
                    onChange={handleChange}
                    name="username"
                    type="text"
                    placeholder="Nome do usuário"
                    className="w-full px-3 py-2 border border-gray-400 rounded-lg text-[#0A1E33] placeholder:text-gray-500"
                />
            </div>

            <div className="flex flex-col">
                <label htmlFor="email" className="text-[#0A1E33] font-semibold mb-1">
                    E-mail
                </label>
                <input
                    id="email"
                    onChange={handleChange}
                    name="email"
                    type="email"
                    placeholder="Seu e-mail"
                    className="w-full px-3 py-2 border border-gray-400 rounded-lg text-[#0A1E33] placeholder:text-gray-500"
                />
            </div>

            <div className="flex flex-col">
                <label htmlFor="password" className="text-[#0A1E33] font-semibold mb-1">
                    Senha
                </label>
                <input
                    id="password"
                    onChange={handleChange}
                    name="password"
                    type="password"
                    placeholder="Sua senha"
                    className="w-full px-3 py-2 border border-gray-400 rounded-lg text-[#0A1E33] placeholder:text-gray-500"
                />
            </div>

            <div className="flex flex-col">
                <label htmlFor="confirmPassword" className="text-[#0A1E33] font-semibold mb-1">
                    Confirmar Senha
                </label>
                <input
                    id="confirmPassword"
                    onChange={handleChange}
                    name="confirmPassword"
                    type="password"
                    placeholder="Confirme sua senha"
                    className="w-full px-3 py-2 border border-gray-400 rounded-lg text-[#0A1E33] placeholder:text-gray-500"
                />
            </div>

            <button
                type="submit"
                className="mt-4 bg-[#0A1E33] text-white py-2 px-4 rounded-lg hover:bg-[#143554] transition"
            >
                Registrar
            </button>
        </form>
    );
};



export { LoginForm, RegisterForm }  