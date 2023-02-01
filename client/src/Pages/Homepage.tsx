import logo from '../logo.svg';
import backdrop from '../Assets/mock.jpg';
import Header from '../Components/Header';
import GalleryContainer from '../Components/GalleryContainer';

export default function Homepage() {
    return (
        <div className="App home-bg-image w-full h-screen">
            <Header/>
            <div className='flex w-full h-3/5 justify-center items-center'>
                <h1 className="text-slate-100 text-[3em]">Welcome to Hello World</h1>
            </div>
            <GalleryContainer/>
        </div>
    )
}