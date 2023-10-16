import { useState } from "react"


const ProductDisplay = ({  product, selectProduct }) => {

    const [ isHover, setIsHover ] = useState(false)


    const getProductName = (name) => {
        const nameArr = name.split(" ")
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

        return `
            type: ${type.join(" ")} | size: ${size.join("")} | finish: ${finish.join(" ")}`
    }


    const getProductPrice = (price) => {
        const euro = Intl.NumberFormat('en-DE', {
            style: 'currency',
            currency: 'EUR',
            useGrouping: false,
        })

        return euro.format(price)
    }

    return (

        <div
            onClick={() => selectProduct(product.id)}
        >

            <p>{getProductName(product.name)}</p>

            <p>{getProductPrice(product.price)}</p>

        </div>
    )

}

export default ProductDisplay