import { useState } from "react"

const Product = ({  product, handleProduct }) => {

    const [ isHover, setIsHover ] = useState(false)

    const styles = {
        container: {
            display: 'flex',
            flexDirection: 'column',
            margin: '0 auto',
            minWidth: '18rem',
            backgroundColor: isHover ? 'rgb(224, 255, 255)' : 'white',
            borderBottom: 'solid 1px black',
            cursor: 'pointer'
        },
        productInfo: {
            color: 'black',
            textAlign: 'center',
            padding: '.1rem .8rem',
            fontSize: '.9rem'
        },
        productPrice: {
            color: 'black',
            textAlign: 'center'
        }
    }

    const nameArr = product.name.split(" ")
    const type = []
    const size = []
    const finish = []


    nameArr.map((el, i) => {
        if(i === 0) {
            type.push(el)
        } else if(i < 4) {
            size.push(el)
        } else {
            finish.push(el)
        }
    })


    const getPrice = (price) => {
        const euro = Intl.NumberFormat('en-DE', {
            style: 'currency',
            currency: 'EUR',
            useGrouping: false,
        })

        return euro.format(price)
    }


    return (
        <div 
            style={styles.container}
            onMouseEnter={() => setIsHover(true)}
            onMouseLeave={() => setIsHover(false)}
            onClick={() => handleProduct(product.id)}
        >
            <p 
                style={styles.productInfo}
                >{`type: ${type.join(" ")} | size: ${size.join("")} | finish: ${finish.join(" ")}`}
            </p>
            <p 
                style={styles.productPrice}
                >{`${getPrice(product.price)}`}
            </p>
        </div>
    )


}

export default Product