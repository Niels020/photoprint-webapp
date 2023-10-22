

const Modal = ({ children, closeModal }) => {


    const styles = {
        modal: {
            'position': 'fixed',
            'zIndex': '1000000',
            'paddingTop': '3rem',
            'left': '0',
            'top': '0',
            'width': '100%',
            'height': '100%',
            'overflow': 'auto',
            'backgroundColor': 'rgba(255,255,255, .8)'
        },
        content: {
            'backgroundColor': 'black',
            'margin': '0 auto',
            'padding': '20px',
            'border': '1px solid #888',
            'width': 'calc(100% - 3rem)'
        }, 
        closeModalBtn: {
            'fontSize': '1.8rem',
            'border': '1px solid white',
            'position': 'fixed',
            'top': '3rem',
            'right': '1.5rem',
            'padding': '0 8px 4px',
            'cursor': 'pointer'
        },
    }

    return (
        <div style={styles.modal}>
            <div style={styles.content}>
                <div 
                    style={styles.closeModalBtn} 
                    onClick={() => closeModal()}
                >x
                </div>
                {children}
            </div>
            
        </div>
    )
}

export default Modal