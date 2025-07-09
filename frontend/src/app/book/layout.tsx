import { Metadata } from "next";

export const metadata: Metadata = {
    title: "Books | Book Search",
}
export default function BookLayout({ children }: { children: React.ReactNode }) {
  return <>{children}</>;
}