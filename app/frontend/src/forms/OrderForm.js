import { useState } from 'react'
import useFetch from '../hooks/useFetch'
import ProductDisplay from '../components/ProductDisplay'
import './OrderForm.css'

const OrderForm = () => {

    const [orderData, setOrderData] = useState({id: null, quantity: '1'})
    const [data, isLoading, error] = useFetch('http://localhost:8080/product_definition/all')


    const selectProduct = (id) => {

        data.map(product => {
            if(product.id === id) {
                setOrderData(prevOrderData => ({ ...prevOrderData, id: product.id}))
            }
        })
    }

    const selectQuantity = (e) => {
        setOrderData(prevOrderData => ({ ...prevOrderData, quantity: e.target.value }))
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log(orderData)
    }

    const clearOrderDataId = () => {
        setOrderData(prevOrderData => ({...prevOrderData, id: null}))
    }

    return (
        <form
            className='form-container' 
            onSubmit={handleSubmit}
        >

            <p 
                className='product-label'
            >{!orderData.id ? 'select format:' : 'selected'}
            </p>

            {!orderData.id && <div className='products-container'>
                
                { isLoading && <p>Loading...</p> }
                { error && <p>{error}</p>}
                { data && data.map(el => {
                    return (

                        <div className='product-container'>
                            <ProductDisplay 
                                key={el.id}
                                product={el} 
                                selectProduct={selectProduct} 
                            />
                        </div>
                    )
                }) }
            </div>}

            {orderData.id &&
            
                <div>
                    <ProductDisplay 
                        key={orderData.id}
                        product={data[orderData.id]} 
                        selectProduct={selectProduct} 
                    />
                    <button 
                        className='button' 
                        type='button'
                        onClick={clearOrderDataId}
                        >return
                    </button>
                </div>
            }

            <div className='quantity-container'>
                <label
                    className='quantity-label'
                    htmlFor='form-quantity'
                >select quantity:
                </label>
                <input 
                    className='quantity-input'
                    value={orderData.quantity}
                    onChange={selectQuantity}
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