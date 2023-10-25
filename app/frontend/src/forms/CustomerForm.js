import { useState } from 'react';
import './Form.css'

const CustomerForm = () => {

    const [customer, setCustomer] = useState({
        firstName: "",
        lastName: "",
        email: "",
        phoneNumber: ""
    })

    const [customerAddress, setCustomerAddress] = useState({
        street: "",
        streetNumber: "",
        areaCode: "",
        city: "",
        country: ""
    })

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log(customer, customerAddress)
    }

    const handleCustomerChange = (e) => {
        const { name, value } = e.target;
        setCustomer(prevState => ({ ...prevState, [name]: value }))
    }

    const handleAddressChange = (e) => {
        const { name, value } = e.target;
        setCustomerAddress(prevState => ({ ...prevState, [name]: value }))
    }

    return (

        <form 
            className='customer-form-container'
            onSubmit={handleSubmit}
        >
            <label>First Name</label>
            <input
                type="text"
                name="firstName"
                value={customer.firstName}
                onChange={handleCustomerChange}
            />
            <label>Last Name</label>
            <input
                type="text"
                name="lastName"
                value={customer.lastName}
                onChange={handleCustomerChange}
            />
            <label>Email</label>
            <input
                type="email"
                name="email"
                value={customer.email}
                onChange={handleCustomerChange}
            />
            <label>Phone Number</label>
            <input
                type="text"
                name="phoneNumber"
                value={customer.phoneNumber}
                onChange={handleCustomerChange}
            />

            <label>Street</label>
            <input
                type="text"
                name="street"
                value={customerAddress.street}
                onChange={handleAddressChange}
            />
            <label>Street Number</label>
            <input
                type="text"
                name="streetNumber"
                value={customerAddress.streetNumber}
                onChange={handleAddressChange}
            />
            <label>Area Code</label>
            <input
                type="text"
                name="areaCode"
                value={customerAddress.areaCode}
                onChange={handleAddressChange}
            />
            <label>City</label>
            <input
                type="text"
                name="city"
                value={customerAddress.city}
                onChange={handleAddressChange}
            />
            <label>Country</label>
            <input
                type="text"
                name="country"
                value={customerAddress.country}
                onChange={handleAddressChange}
            />
            <button className='button'>submit</button>
        </form>

    )
}

export default CustomerForm