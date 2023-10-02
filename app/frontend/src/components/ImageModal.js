import React from 'react';
import Modal from 'react-modal';

Modal.setAppElement('#root');

function ImageModal({ isOpen, onClose, imageUrl }) {
    
    const styles = {
        modal: {
            display: 'flex',
            flexDirection: 'column'
        },
        title: {
            color: 'black',
            alignSelf: 'center',
            fontSize: '2.4rem',
            fontFamily: `'Chakra Petch', sans-serif`
        },
        button: {
            color: 'black',
            alignSelf: 'end',
            width: '4rem',
            cursor: 'pointer'
        },
        image: {
            width: '100%'
        }
    }

    return (

        <Modal
            isOpen={isOpen}
            onRequestClose={onClose}
            contentLabel="Image Preview"
        >
            <div style={styles.modal}>
                <h2 style={styles.title}>preview</h2>

                <button style={styles.button} onClick={onClose}>close</button>

                {imageUrl && (
                    <img
                        style={styles.image}
                        src={imageUrl}
                        alt="Uploaded"
                    />
                )}
            </div>
        </Modal>

    )
}

export default ImageModal;