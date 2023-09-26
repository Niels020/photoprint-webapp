import './Product.css'

const Product = ({  product, handleProduct }) => {

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
            className='container' 
            onClick={() => handleProduct(product.id)}
        >
            <p 
                className='product-info'
                >{`type: ${type.join(" ")} | size: ${size.join("")} | finish: ${finish.join(" ")}`}
            </p>
            <p 
                className='product-price'
                >{`${getPrice(product.price)}`}
            </p>
        </div>
    )


}

export default Product