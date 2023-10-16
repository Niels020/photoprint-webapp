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
        <div className='container'>

            <nav className="nav">

                <div className='nav-logo'>
                    <Link 
                        className='nav-link' 
                        to={`/`}
                        >LOGO
                    </Link>
                </div>

                <ul className='nav-links'>

                    <li>
                        <Link 
                            className='nav-link' 
                            to={`/`}
                            >home
                        </Link>
                    </li>

                    <li>
                        <Link 
                            className='nav-link' 
                            to={`shop`}
                            >shop
                        </Link>
                    </li>

                    <li>
                        <Link 
                            className='nav-link' 
                            to={`about`}
                            >about us
                        </Link>
                    </li>

                </ul>

            </nav>

            <div className='scroll-container'>

                <main>
                    <Outlet />
                </main>

                <footer className='footer'>
                    <div>facebook</div>
                    <div>twitter</div>
                    <div>insta</div>
                </footer>
            </div>
            

        </div>
    )
}


export default App