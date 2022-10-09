import React from "react";
import "../styles/Pages/pageLayout.css";
import '../styles/Pages/myaccount.css'
import  '../styles/component/drop-down.css';
import { Link } from "react-router-dom";
import { useNavigate } from "react-router";
import Subscription from "./subscription";
import Dropdown from "../components/drop-down";
import LeftNavbar from "../components/left-navbar";
import UpdateStudent from "../components/student-account";
import UpdateLecturer from "../components/lecturer-account";
import UpdateAdmin from "../components/admin-account";
const MyAccount = () => {

    const { loginStatus } = sessionStorage
    const { role } = sessionStorage
    const navigate = useNavigate();


    return (
        <div className="layout"><h2 className="text-center">My Account</h2>
            <div className="dropdown"><Dropdown /></div>
            {loginStatus ?
            <div>
                 <LeftNavbar />
                 {role==="student" ? <UpdateStudent/> : null}
                { role==="lecturer" ? <UpdateLecturer/> : null}
                 {role==="admin"?<UpdateAdmin/>:null}
            </div>
               // no use further because of ternary opertor
                :
                <div>
                <div className="text-center mid">
                    <h4><ul><Link to="/login">Login here</Link></ul></h4>
                    <h4><ul><Link to="/studentsignup">Singup as Student</Link></ul></h4>
                    <h4><ul><Link to="/lecturersignup">Singup as Lecturer</Link></ul></h4>
                </div>
                <h2>Here Some plans for lecturer</h2>
                <div><Subscription></Subscription></div>
                <div className="gap"></div>
                </div>
            }
        </div>

    )
}



export default MyAccount