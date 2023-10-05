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
                <div className='nav-logo'><Link to={`/`}>LOGO</Link></div>
                <ul className='nav-links'>
                    <li className='nav-link'>
                        <Link to={`/`}>HOME</Link>
                    </li>
                    <li className='nav-link'>
                        <Link to={`shop`}>SHOP</Link>
                    </li>
                    <li className='nav-link'>
                        <Link to={`about`}>ABOUT US</Link>
                    </li>
                </ul>
            </nav>

            <div className='container'>
                <div className="pages">
                    <Outlet />
                </div>

                <div className='footer'>
                    <div>facebook</div>
                    <div>twitter</div>
                    <div>insta</div>
                </div>
            </div>
            

        </div>
    )
}


export default App