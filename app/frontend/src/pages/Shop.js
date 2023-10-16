import { useState } from 'react'
import ImageModal from '../components/ImageModal'
import OrderForm from '../forms/OrderForm'


const Shop = () => {

    const [selectedImage, setSelectedImage] = useState(null)
    const [isModalOpen, setIsModalOpen] = useState(false)
    
  
    const handleImageUpload = (e) => {
        const file = e.target.files[0]

        if(file) {
            setSelectedImage(URL.createObjectURL(file))
        }
    }


    return (

        <div className='page'>

            <div className='hero-bg-img'></div>

            <h2 className='subtitle'>photo shop</h2>

            <p className='paragraph'
                >This is our shop. In just a few simple steps we can start 
                creating your own framed image. First please select 
                the image you would like to have printed by clicking on 
                the button below.
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
                htmlFor='input' 
                >select image
            </label>

             
            {selectedImage && <button 
                className='button' 
                type='button' 
                onClick={() => setIsModalOpen(true)}
                >view image
            </button> }

            <ImageModal
                isOpen={ isModalOpen }
                onClose={ () => setIsModalOpen(false) }
                imageUrl={ selectedImage }
            />



            <OrderForm /> 



            
        </div>
    )
}

export default Shop