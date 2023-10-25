import useProductFormat from '../hooks/useProductFormat'
import './Form.css'

const ProductForm = (
    { 
        products, 
        order, 
        submitOrder, 
        addOrderId,  
        addOrderQuantity,
        resetOrderId
    }) => {

    const [ getInfo, getPrice ] = useProductFormat()


    const handleSubmit = (e) => {
        e.preventDefault()
        submitOrder()
    }

    const handleOrderId = (id) => {
        const orderId = products.find(product => product.id === id).id
        addOrderId(orderId)
    }

    const handleOrderQuantity = (e) => {
        const quantity = parseInt(e.target.value)
        addOrderQuantity(quantity)
    }

    const displayProducts = () => {
        return products.map(product => {

            const [format, size, finish] = getInfo(product.name)
            const price = getPrice(product.price)

            return (
                <div key={product.id} onClick={() => handleOrderId(product.id)}>
                    <p>{`${format} | ${size} | ${finish}`}</p>
                    <p>{`price: ${price}`}</p>
                </div>
            )
        })
    }

    const displayProduct = () => {
        const [format, size, finish] = getInfo(products[order.id].name)
        const price = getPrice(products[order.id].price)

        return (
            <div onClick={resetOrderId}>
                <p>{`${format} | ${size} | ${finish}`}</p>
                <p>{`price: ${price}`}</p>
            </div>
        )
    }

    return (
        <form onSubmit={handleSubmit} className='product-form-container'>

            <div className='products-container'>
                
                { 
                    !order.id && 
                        displayProducts()
                }
                { 
                    order.id && 
                        displayProduct()
                }
            </div>

            <div className='quantity-container'>
                <label
                    className='quantity-label'
                    htmlFor='form-quantity'
                >select quantity:
                </label>
                <input 
                    className='quantity-input'
                    value={order.quantity}
                    onChange={handleOrderQuantity}
                    id='form-quantity'
                    type='number'
                    max={20}
                    min={1}
                />
            </div>
            
            <button 
                className='order-submit-button button'
                type='submit'
                >add to cart
            </button>

        </form>
    )
}

export default ProductForm