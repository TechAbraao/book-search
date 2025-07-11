import { LoginForm } from "@/components/Forms/AuthForms"
import { LoginLayout } from "@/layouts/AuthPageLayouts"

const LoginPage = () => {
    return (
        <LoginLayout>
            <LoginForm />
        </LoginLayout>
    )
}

export { LoginPage } 