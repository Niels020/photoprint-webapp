import { useState } from 'react'
import  useFetch  from '../hooks/useFetch'
import ImageModal from '../components/ImageModal'
import ProductForm from '../forms/ProductForm'
import OrderForm from '../forms/OrderForm'
import Modal from '../components/Modal'

const Shop = () => {
    
    const [order, setOrder] = useState({id: null, quantity: 1})
    const [orderCollection, setOrderCollection] = useState([])
    const [selectedImage, setSelectedImage] = useState(null)
    const [isModalOpen, setIsModalOpen] = useState(false)
    const [isOrderFormOpen, setIsOrderFormOpen] = useState(false)
    const [products, isLoading, error] = useFetch('http://localhost:8080/product_definition/all')

    const handleImageUpload = (e) => {
        const file = e.target.files[0]

        if(file) {
            setSelectedImage(URL.createObjectURL(file))
        }
    }

    const addToOrderCollection = () => {
        setOrderCollection(prevOrderCollection => [...prevOrderCollection, order])
    }

    const addOrderId = (orderId) => {
        setOrder(prevOrder => ({ ...prevOrder, id: orderId}))
    }

    const addOrderQuantity = (orderQuantity) => {
        setOrder(prevOrder => ({ ...prevOrder, quantity: orderQuantity}))
    }

    const resetOrder = () => {
        setOrder({id: null, quantity: 1})
    }

    const resetOrderId = () => {
        setOrder(prevOrder => ({...prevOrder, id: null}))
    }

    const openOrderForm = () => {
        setIsOrderFormOpen(true)
    }

    const closeOrderForm = () => {
        setIsOrderFormOpen(false)
    }

    return (

        <div className='page'>

            <div className='hero-bg-img'></div>

            <h2 className='subtitle'>photo shop</h2>

            <p className='paragraph'
                >This is our shop. In just a few simple steps we can start 
                creating your own framed image. First select 
                the image you would like to have printed. To do this please click on 
                the button below. By clicking it again you can pick another image.
            </p>

            <input
                style={{display: 'none'}}
                id='input'
                type='file'
                accept='image/*'
                onChange={ handleImageUpload }
            />

            <label
                className='clickable' 
                htmlFor='input' >
                {
                    !selectedImage ? 'select image' : 'alter image'
                }
            </label>

             
            { 
                selectedImage && 
                    <button 
                        className='button' 
                        type='button' 
                        onClick={() => setIsModalOpen(true)}
                        >preview image
                    </button> 
            }

            <ImageModal
                isOpen={ isModalOpen }
                onClose={ () => setIsModalOpen(false) }
                imageUrl={ selectedImage }
            />

            { 
                selectedImage &&
                    <p className='paragraph'>
                        What you see here is our options menu. There are countless 
                        possibilities for different materials, sizes and finishes but in our experience most of  our clients find what they need in the combinations seen below. Should you wish for a more personal sollution, we can of course help you if you contact us.
                    </p>
            }

            { isLoading && <p>Loading...</p> }
            { error && <p>{error}</p>}
            { 
                selectedImage && 
                    <ProductForm
                        products={products}
                        order={order}
                        submitOrder={addToOrderCollection} 
                        addOrderId={addOrderId}
                        addOrderQuantity={addOrderQuantity}
                        resetOrder={resetOrder}
                        resetOrderId={resetOrderId}
                    />
            }


            { 
                orderCollection.length !== 0 &&
                    <div 
                        className='custom-orderpage-link'
                        onClick={openOrderForm}>
                        Order
                    </div>
            }

            {
                isOrderFormOpen && 
                    <Modal closeModal={closeOrderForm}>
                        <OrderForm orderCollection={orderCollection} />
                    </Modal>
            }

        </div>
    )
}

export default Shop