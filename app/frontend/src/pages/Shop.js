import { useState } from 'react'
import useFetch  from '../hooks/useFetch'
import ProductForm from '../forms/ProductForm'
import OrderForm from '../forms/OrderForm'
import CustomerForm from '../forms/CustomerForm'
import Modal from '../components/Modal'

const Shop = () => {
    
    const [order, setOrder] = useState({id: null, quantity: 1})
    const [orderCollection, setOrderCollection] = useState([])
    const [selectedImage, setSelectedImage] = useState(null)
    const [isImageModalOpen, setIsImageModalOpen] = useState(false)
    const [isOrderFormModalOpen, setIsOrderFormModalOpen] = useState(false)
    const [products, isLoading, error] = useFetch('http://localhost:8080/product_definition/all')

    // TEST DATA ==========================
    // const filltestData = () => {
    //     setOrderCollection([
    //         {id: 2, quantity: 3},
    //         {id: 4, quantity: 2},
    //         {id: 5, quantity: 1}
    //     ])
    // }
    // useEffect(() => filltestData, [])
    // TEST DATA ==========================

    const handleImageUpload = (e) => {
        const file = e.target.files[0]

        if(file) {
            setSelectedImage(URL.createObjectURL(file))
        }
    }

    const addToOrderCollection = () => {
        const match = orderCollection.find(el => el.id === order.id)

        if(!match) {
            setOrderCollection(prev => [...prev, order])
        } else {
            setOrderCollection(prev => prev.map(el => {
                return el.id === match.id ? 
                    {id: el.id, quantity: el.quantity + match.quantity} : el    
            }))
        }
        
        setOrder({id: null, quantity: 1})
    }

    const addOrderId = (orderId) => {
        setOrder(prev => ({...prev, id: orderId}))
    }

    const addOrderQuantity = (orderQuantity) => {
        setOrder(prev => ({...prev, quantity: orderQuantity}))
    }

    const resetOrderId = () => {
        setOrder(prev => ({...prev, id: null}))
    }

    const openOrderFormModal = () => {
        setIsOrderFormModalOpen(true)
    }

    const closeOrderFormModal = () => {
        setIsOrderFormModalOpen(false)
    }

    const openImageModal = () => {
        setIsImageModalOpen(true)
    }

    const closeImageModal = () => {
        setIsImageModalOpen(false)
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
                onChange={handleImageUpload}
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
                        onClick={openImageModal}
                        >preview image
                    </button> 
            }

            { 
                isImageModalOpen &&
                    <Modal closeModal={closeImageModal}>
                        <img 
                            src={selectedImage} 
                            alt='preview of your uploaded file'
                        />
                    </Modal>
            }

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
                        resetOrderId={resetOrderId}
                    />
            }


            { 
                orderCollection.length !== 0 &&
                    <div 
                        className='custom-orderpage-link'
                        onClick={openOrderFormModal}>
                        Order
                    </div>
            }

            {
                isOrderFormModalOpen && 
                    <Modal closeModal={closeOrderFormModal}>
                        <OrderForm 
                            orderCollection={orderCollection}
                            products={products}
                        />
                    </Modal>
            }

            {
                <Modal>
                    <CustomerForm/>
                </Modal>
            }

        </div>
    )
}

export default Shop