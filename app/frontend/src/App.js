import { 
    createBrowserRouter, 
    createRoutesFromElements, 
    Route, 
    RouterProvider
} from 'react-router-dom'
import Root from './Root'
import Home from './pages/Home'
import Shop from './pages/Shop'
import Contact from './pages/Contact'
import "./App.css"


const App = () => {

    const router = createBrowserRouter(
        createRoutesFromElements(
            <Route path="/" element={<Root />}>
                <Route index element={<Home />} />
                <Route path="shop" element={<Shop />} />
                <Route path="contact" element={<Contact />} />
            </Route>
        )
    )

    return (
        <RouterProvider router={router}/>
    )
}

export default App