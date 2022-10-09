import React from "react";
import '../styles/Pages/myaccount.css'
import { Link } from "react-router-dom";



const LeftNavbar=()=>{

    const { loginStatus } = sessionStorage
    const { role } = sessionStorage
    

    return(
        <div className="text-center " >
                    <div className="bar">
                        <ul>
                            <ul><Link to="/home">Home</Link></ul>
                            {role==="admin" ? <ul><Link to="/home">Delete Course</Link></ul> : null}
                            {role==="admin" ? <ul><Link to="/remove-lecturer">Remove Leccturer</Link></ul> : null}
                            {role==="lecturer" ? <ul><Link to="/my-courses">My Course</Link></ul> : null}
                            {role==="lecturer" ? <ul><Link to="/add-course">Add Course</Link></ul> : null}
                            {role==="lecturer" ? <ul><Link to="/select-course">Add Test & Add Video</Link></ul> : null}
                            {role==="lecturer" ? <ul><Link to="/subscription-detail">Subscription-detail</Link></ul> : null}
                            {role==="student" ? <ul><Link to="/enroll-courses">Enrolled-Courses</Link></ul> : null}
                            {role==="student" ? <ul><Link to="/give-test">Available-Test</Link></ul> : null}
                            
                            <ul><Link to="/login">Logout</Link></ul>
                        </ul>
                    </div>
                </div>
    )
}


export default LeftNavbar