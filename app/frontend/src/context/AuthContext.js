import { createContext, useState } from 'react'

const AuthContext = createContext()

export const AuthProvider = ({ children }) => {
    const [id, setId] = useState(null)

    return (
        <AuthContext.Provider value={{id, setId}}>{children}</AuthContext.Provider>
    )
}

export default AuthContext

/*
export const useAuthContext = () => {
    const context = useContext(AuthContext)

    if(!AuthContext) {
        throw new Error(
            'Must be used within a Authcontext provider'
        )
    }

    return context
}
*/