import React from 'react'
import ReactStars from "react-rating-stars-component";
import { toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import axios from 'axios'
import { Link } from 'react-router-dom';
import { Navigate, useNavigate } from 'react-router';


const SelectCourseCompo = ({ course }) => {

    const role = sessionStorage.role
    console.log("role is " + role)
    const navigate = useNavigate()
    const ratingChanged = (rating) => {
        toast.success(rating)
    };

    return (
        <div>
            {role == "lecturer"
                && (
                    <div className='selectCourseCompo'>
                        <div className="container">
                            <div className="row">
                                <h4>{course.courseTitle}</h4>
                                <div className="btn btn-success float-end">
                                    <button style={{marginRight:75}}  onClick={() => {
                                        navigate('/add-test', { state: { c: course } })
                                    }} >Add Test</button>
                                   
                                    <button style={{marginLeft:75}}  onClick={() => {
                                        navigate('/add-video', { state: { c: course } })
                                    }} >Add Video</button>

                                </div>

                            </div>
                        </div>
                    </div>
                )}
        </div>
    )
}


export default SelectCourseCompo