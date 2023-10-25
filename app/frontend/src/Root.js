import { Link, Outlet } from 'react-router-dom'

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

export default Root