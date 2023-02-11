export default function Header() {
    return (
        <section className="text-slate-100/50 w-full  h-48 flex justify-between items-center p-10">
            <h1 className=" text-[4em]">Anthony Photography</h1>
            <nav className="flex">
                <a className="text-[1.75em] mr-6 cursor-pointer">Contact Me</a>
                <a className="text-[1.75em] mr-6 cursor-pointer">Profile</a>
                <a className="text-[1.75em] cursor-pointer">Cart</a>
            </nav>
        </section>
    )
}