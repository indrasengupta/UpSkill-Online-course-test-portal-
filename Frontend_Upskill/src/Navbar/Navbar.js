import React from 'react'
import "./navbar.css"
import { Link } from 'react-router-dom';


 const Navbar = () => (
     <>
         <nav className='main-nav'>
             {/*logo part*/}
             <div className='logo'>
                <h2>
                    <span>U</span>pskill
                </h2>
             </div>
             {/*manu part*/}
             <div className='menu-link'>
                 <ul>
                     <li>
                     <Link to='/'>Home</Link>
                     </li>
                     <li>
                     <Link to='/login'>Register/Login</Link>
                     </li>
                     <li>
                     <Link to='/Contactus'>Contact Us</Link>
                     </li>
                     <li>
                     <Link to='/Aboutus'>About Us</Link>
                     </li>
                 </ul>
             </div>
             <div>
  
  </div>    
         </nav>
         
         
     </>
 )
export default Navbar;