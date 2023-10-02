import { Link } from 'react-router-dom'
import Galery from '../components/Galery'
import './Page.css'

const Home = () => {

    return (
        <div className='page home'>
            <div className='hero-bg-img'></div>
            <h1 className='title'
                >Photo World Pro
            </h1>
            <p className='paragraph'
                >We are Photo World. Cutting edge technology, 
                decades of experience and out-of-the-box service 
                sets us apart in the world on high quality photo printing. 
                We love helping professionals, hobbyists and everyone else 
                to transform there images into beautiful prints.
            </p>

            <Galery />

            <p className='paragraph'
                >In our shop you can find everything about formats, finishes 
                and frames to perfectly create your own masterpiece. There 
                are a lot of options and we hope you can find these solutions
                exactly to your needs.
            </p>
            <Link className='link' to={'/shop'}>shop</Link>
            <p className='paragraph'
                >Should you require more specialized help, have any questions
                about our products or need other assistance. In our contact 
                page you can find multiple ways to contact us. We love to help 
                you anyway we can.
            </p>
            <Link className='link' to={'/contact'}>about us</Link>
        </div>
    )
}

export default Home