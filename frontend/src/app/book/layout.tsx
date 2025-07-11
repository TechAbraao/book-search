import { Metadata } from "next";

export const metadata: Metadata = {
  title: "Books | Book Search",
  description: "Search for books, authors, and more",
  icons: {
    icon: "../icons/favicon.ico",
  }
}
export default function BookLayout({ children }: { children: React.ReactNode }) {
  return <>{children}</>;
}