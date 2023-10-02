import galeryOne from '../img/galery_1.jpg'
import galeryTwo from '../img/galery_2.jpg'
import galeryThree from '../img/galery_3.jpg'
import galeryFour from '../img/galery_4.jpg'
import galeryFive from '../img/galery_5.jpg'
import galerySix from '../img/galery_6.jpg'
import galerySeven from '../img/galery_7.jpg'

const Galery = () => {

    const styles = {
        galery: {
            margin: '3.2rem -3.2rem 2.8rem 3.2rem',
            display: 'grid',
            gridTemplateColumns: 'repeat(3, auto)',
        },
        image: {
            objectFit: 'cover',
            width: '100%',
            height: '100px'
        }
    }
    

    return (
        <div style={styles.galery}>
            <img style={styles.image} src={galeryOne} alt=''/>
            <img style={styles.image} src={galeryTwo} alt=''/>
            <div></div>
            <img style={styles.image} src={galeryThree} alt=''/>
            <img style={styles.image} src={galeryFour} alt=''/>
            <img style={styles.image} src={galeryFive} alt=''/>
            <img style={styles.image} src={galerySix} alt=''/>
            <div></div>
            <img style={styles.image} src={galerySeven} alt=''/>
        </div>
    )
}

export default Galery