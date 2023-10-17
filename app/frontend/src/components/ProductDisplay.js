
const ProductDisplay = ({ product }) => {

    const getProductInfo = (info) => {
        const infoArr = info.split(" ")
        const name = []
        const size = []
        const finish = []

        infoArr.map((el, i) => {
            if(i === 0) {
                name.push(el)
            } else if(i < 4) {
                size.push(el)
            } else {
                finish.push(el)
            }
        })

        return [ name.join(" "), size.join(""), finish.join(" ") ]
    }

    const getProductPrice = (price) => {
        const euro = Intl.NumberFormat('en-DE', {
            style: 'currency',
            currency: 'EUR',
            useGrouping: false,
        })

        return euro.format(price)
    }

    const [ productName, productSize, productFinish ] = getProductInfo(product.name)
    const productPrice = getProductPrice(product.price)

    return (
        <div>
            <p>{productName}</p>
            <p>{productSize}</p>
            <p>{productFinish}</p>
            <p>{productPrice}</p>
        </div>
    )
}

export default ProductDisplay