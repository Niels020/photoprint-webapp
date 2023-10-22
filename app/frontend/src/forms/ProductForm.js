import ProductDisplay from '../components/ProductDisplay'
import './ProductForm.css'

const ProductForm = (
    { 
        products, 
        order, 
        submitOrder, 
        addOrderId,  
        addOrderQuantity,
        resetOrder,
        resetOrderId
    }) => {


    const handleSubmit = (e) => {
        e.preventDefault()
        submitOrder()
        resetOrder()

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
        return products.map(product => (

            <div key={product.id} onClick={() => handleOrderId(product.id)}>
                < ProductDisplay product={product} />
            </div>
        ))
    }

    const displayProduct = () => {
        return (
            <div onClick={resetOrderId}>
                < ProductDisplay product={products[order.id -1]} />
            </div>
        )

    }

    return (
        <form onSubmit={handleSubmit} className='form-container'>

            <div className='products-container'>
                
                { 
                    products && !order.id && 
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