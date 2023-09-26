import { Link } from 'react-router-dom'
import galeryOne from '../img/galery_1.jpg'
import galeryTwo from '../img/galery_2.jpg'
import galeryThree from '../img/galery_3.jpg'
import galeryFour from '../img/galery_4.jpg'
import galeryFive from '../img/galery_5.jpg'
import galerySix from '../img/galery_6.jpg'
import galerySeven from '../img/galery_7.jpg'
import './Page.css'

const Home = () => {

    return (
        <div className='page home'>
            <div className='hero-bg-img'></div>
            <h1 className='title home--title'
                >Photo World Pro
            </h1>
            <p className='paragraph home--intro'
                >We are Photo World. Cutting edge technology, 
                decades of experience and out-of-the-box service 
                sets us apart in the world on high quality photo printing. 
                We love helping professionals, hobbyists and everyone else 
                to transform there images into beautiful prints.
            </p>
            <div className='home--galery'>
                <img className='image-one' src={galeryOne} alt=''/>
                <img className='image-two' src={galeryTwo} alt=''/>
                <img className='image-three' src={galeryThree} alt=''/>
                <img className='image-four' src={galeryFour} alt=''/>
                <img className='image-five' src={galeryFive} alt=''/>
                <img className='image-six' src={galerySix} alt=''/>
                <img className='image-seven' src={galerySeven} alt=''/>
            </div>
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