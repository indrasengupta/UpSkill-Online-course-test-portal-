import { Link } from 'react-router-dom'
import React,{useEffect} from 'react'
// import '../styles/pages/homePage.css'


const Dropdown=()=>{

    const { loginStatus }=sessionStorage;
    const { role }=sessionStorage;

    return(
        <div className="drop-down">
        <div className="float-end">
        <div className="btn-group " role="group">
          <button
            id="btnGroupDrop1"
            type="button"
            className="btn btn-primary dropdown-toggle"
            data-bs-toggle="dropdown"
            aria-expanded="false">
            Home 
          </button>
          <ul className="dropdown-menu" aria-labelledby="btnGroupDrop1">
            <li>
            <Link to="/home" className="dropdown-item">Home</Link>
            </li>
            <li>
            <Link to="/my-account" className="dropdown-item">{loginStatus?"My Account":"Create Account"}</Link>
            </li>
            <li>
            <Link to="/login" className="dropdown-item">{loginStatus?"Logout":"Login"}</Link>
            </li>
          </ul>
        </div>
      </div>
      </div>
    )
}
export default Dropdown