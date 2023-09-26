import React from 'react';
import Modal from 'react-modal';
import './ImageModal.css'

Modal.setAppElement('#root');

function ImageModal({ isOpen, onClose, imageUrl }) {
    

    return (

        <Modal
            isOpen={isOpen}
            onRequestClose={onClose}
            contentLabel="Image Preview"
        >
            <div className='content'>
                <h2 className='title'>preview</h2>

                <button className='button' onClick={onClose}>close</button>

                {imageUrl && (
                    <img
                        className='image'
                        src={imageUrl}
                        alt="Uploaded"
                    />
                )}
            </div>
        </Modal>

    )
}

export default ImageModal;