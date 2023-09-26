import { 
    createBrowserRouter, 
    createRoutesFromElements, 
    Route, RouterProvider, 
    Link, 
    Outlet 
} from 'react-router-dom'
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
        <div>
            <RouterProvider router={router}/>
        </div>  
    )
}


const Root = () => {
    return (
        <div className='body'>
            <nav className="nav">
                <ul>
                    <li>
                        <Link to={`/`}>Home</Link>
                    </li>
                    <li>
                        <Link to={`shop`}>Shop</Link>
                    </li>
                    <li>
                        <Link to={`about`}>About Us</Link>
                    </li>
                </ul>
            </nav>
            <div className="pages">
                <Outlet />
            </div>
        </div>
    )
}


export default App