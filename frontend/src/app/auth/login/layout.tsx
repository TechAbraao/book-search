import { Metadata } from "next";

export const metadata: Metadata = {
  title: "Login | Book Search",
  description: "Login to your account",
  icons: {
    icon: "../icons/favicon.ico",
  }
}
export default function LoginLayout({ children }: { children: React.ReactNode }) {
  return <>{children}</>;
}