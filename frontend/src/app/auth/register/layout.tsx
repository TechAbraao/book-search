import { Metadata } from "next";

export const metadata: Metadata = {
  title: "Register | Book Search",
  description: "Create a new account",  
  icons: {
    icon: "../icons/favicon.ico",
  }
}
export default function RegisterLayout({ children }: { children: React.ReactNode }) {
  return <>{children}</>;
}