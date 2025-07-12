'use client'
import axios from "axios";
import { useState } from "react";
import { registerUser } from "@/services/user.service";
import { Button } from "../Buttons/Buttons";

const LoginForm = () => {
    return (
        <form>
            LOGIN
        </form>
    )
}

const RegisterForm = () => {
    const [form, setForm] = useState({ username: "", email: "", password: "", confirmPassword: "" });
    const [error, setError] = useState({ usernameError: "", emailError: "", passwordError: "", confirmPasswordError: "" });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const data = await registerUser(form)
            console.log("Cadastro feito com sucesso!", data);
        } catch (e) {
            if (axios.isAxiosError(e)) {
                const errorList = e.response?.data.erros;

                const newErrors: typeof error = {
                    usernameError: "",
                    emailError: "",
                    passwordError: "",
                    confirmPasswordError: ""
                };

                errorList?.forEach((err: { field: string; erro: string }) => {
                    const fieldKey = `${err.field}Error` as keyof typeof newErrors;
                    if (fieldKey in newErrors) {
                        newErrors[fieldKey] = err.erro;
                    }
                });
                setError(newErrors);
            }
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
                <p>
                    {error.usernameError && <span className="text-red-500">{error.usernameError}</span>}
                </p>
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
                <p>
                    {error.emailError && <span className="text-red-500">{error.emailError}</span>}
                </p>
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
                <p>
                    {error.passwordError && <span className="text-red-500">{error.passwordError}</span>}
                </p>
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
                <p>
                    {error.confirmPasswordError && <span className="text-red-500">{error.confirmPasswordError}</span>}
                </p>
            </div>
            <div className="flex flex-col w-full gap-2 items-center">
                <Button text="Registrar" button_type="submit" />
                <Button text="Voltar" href="/" button_type="reset" redirect={true}/>
            </div>
        </form>
    );
};



export { LoginForm, RegisterForm }  