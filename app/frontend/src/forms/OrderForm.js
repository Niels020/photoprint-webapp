import { useState } from 'react'
import useFetch from '../hooks/useFetch'
import ProductDisplay from '../components/ProductDisplay'
import './OrderForm.css'

const OrderForm = () => {

    const [order, setOrder] = useState({id: null, quantity: '1'})
    const [data, isLoading, error] = useFetch('http://localhost:8080/product_definition/all')


   const handleSubmit = (e) => {
        e.preventDefault()
        console.log(order)
    }

    const handleProduct = (id) => {

        data.map(product => {
            if(product.id === id) {
                setOrder(prevOrder => ({ ...prevOrder, id: product.id}))
            }
        })    
    }

    const resetProductId = () => {
        setOrder(prevOrder => ({ ...prevOrder, id: null}))
    }

    const handleQuantity = (e) => {
        setOrder(prevOrder => ({ ...prevOrder, quantity: e.target.value }))
    }

 
    return (
        <form
            className='form-container' 
            onSubmit={handleSubmit}
        >

            <p 
                className='product-label'
            >{!order.id ? 'select format:' : 'selected'}
            </p>

  
            <div className='products-container'>
                
                { isLoading && <p>Loading...</p> }
                { error && <p>{error}</p>}
                { data && !order.id && 
                    data.map(el => {
                        return (
                            <div
                                key={el.id}
                                onClick={() => handleProduct(el.id)}
                                >< ProductDisplay product={el} />
                            </div>
                        )
                    })
                }
                { order.id && 
                    <div 
                        onClick={resetProductId}
                        >< ProductDisplay product={data[order.id -1]} />
                    </div>
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
                    onChange={handleQuantity}
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

export default OrderForm