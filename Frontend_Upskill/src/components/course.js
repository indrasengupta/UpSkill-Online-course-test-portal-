import React from 'react'
import ReactStars from "react-rating-stars-component";
import { toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import '../styles/component/courseComponent.css';
import axios from 'axios'
import { Link } from 'react-router-dom';
import { Navigate, useNavigate } from 'react-router';
import { URL } from "../Configurations";
import "../styles/Pages/pageLayout.css";




const Course = ({ course }) => {
    const role = sessionStorage.role
    console.log("role is " + role)
    const navigate = useNavigate()
    const ratingChanged = (rating) => {
        toast.success(rating)
    };

   function removeCourse(){
    axios.delete(`${URL}/course-remove/${course.courseId}`).then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          console.log("Course deleted"+course.courseId);
          window.location.reload();
  
          
        }
        else {
          console.log("Error found");
        }
      })
     }
   

    return (
        <div className='' >
            {role == "admin"
                ? <div>
                <div className="container">
                <div className='delete'> <button className='delete' onClick={removeCourse}>Delete</button></div>
                    <div className="row ">
                        <div className="col-md-8">
                            <button onClick={() => {
                                navigate('/course-detail', { state: { course: course } })
                            }} >{course.title}</button>
                            <div className='lec'>{course.firstName} {course.lastName}</div>
                        </div>
                        <div className="col-4">
                            <ReactStars activeColor="#FFA500" edit={false} value={course.avgRating} size={30} count={5} isHalf={true} />
                            <div style={{ color: 'red', fontWeight: 'bold' }}>{course.fee} Rs</div>
                                                       
                        </div>
                    </div>
                </div>
            </div>


                :

                <div>
                    <div className="container">
                        <div className="row">
                            <div className="col-md-8">
                                <button onClick={() => {
                                    navigate('/course-detail', { state: { course: course } })
                                }} >{course.title}</button>
                                <div className='lec'>{course.firstName} {course.lastName}</div>
                            </div>
                            <div className="col-4">
                                <ReactStars activeColor="yellow" edit={false} value={course.avgRating} size={30} count={5} isHalf={true} />
                                <div style={{ color: 'red', fontWeight: 'bold' }}>{course.fee} Rs</div>

                            </div>
                        </div>
                    </div>
                </div>
            }

        </div>

    )
}


export default Course