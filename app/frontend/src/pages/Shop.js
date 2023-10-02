import { useState } from 'react'
import useFetch from '../hooks/useFetch'
import ImageModal from '../components/ImageModal'
import Product from '../components/Product'
import './Page.css'



const Shop = () => {

    const [products, error] = useFetch('http://localhost:8080/product_definition/all')
    const [selectedImage, setSelectedImage] = useState(null)
    const [isModalOpen, setIsModalOpen] = useState(false)
    const [orderedProduct, setOrderedProduct] = useState({
        id: null,
        quantity: null
    })

    const openModal = () => setIsModalOpen(true)
    const closeModal = () => setIsModalOpen(false)
  
    const handleImageUpload = (e) => {
        const file = e.target.files[0]

        if(file) {
            setSelectedImage(URL.createObjectURL(file))
        }
    }

    const handleProduct = (id) => {
        products.map(product => {
            if(product.id === id) console.log(id)
        })
    }


    return (

        <div className='page shop'>

            <div className='hero-bg-img'></div>

            <h2 className='title'>photo shop</h2>

            <p className='paragraph'
                >This is our shop. In just a few simple steps we can start 
                creating your own framed image. First please select 
                the image you would like to have printed by clicking on 
                the button below.
            </p>

            <input
                className='img-input'
                id='input'
                type='file'
                accept='image/*'
                onChange={ handleImageUpload }
            />

            <label 
                htmlFor='input' 
                className='input-label'
            >{ selectedImage ? 'image uploaded' : 'upload your image here' }
            </label>

            { selectedImage && 
            <button 
                className='preview-btn' 
                type='button' 
                onClick={() => openModal()}
                >preview
            </button> }

            <ImageModal
                isOpen={ isModalOpen }
                onClose={ closeModal }
                imageUrl={ selectedImage }
            />

            { // selectedImage &&
            <form className='shop--form'>

                <div className='shop--form--products'>
                    <p>our print products</p>
                    <div className='shop--form--products-scroll'>
                        { products && products.map(product => {
                            return (
                                <Product 
                                    key={product.id} 
                                    product={product}
                                    handleProduct={handleProduct}
                                />
                            )
                        })}
                    </div>
                </div> 

                <div className='shop--form--quantity'>
                    <label 
                        htmlFor='shop--form--quantity-input'
                        >how many would you like to order?
                    </label>
                    <input 
                        id='shop--form--quantity-input'
                        className='shop--form--quantity-input' 
                        type='number'
                        max={20}
                        min={1}
                    />
                </div>

                <button>add to cart</button>

            </form> }



            
        </div>
    )
}

export default Shop