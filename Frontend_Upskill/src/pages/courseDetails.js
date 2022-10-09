import React, { useEffect } from 'react'
import { useLocation, useNavigate } from 'react-router'
import axios from 'axios'
import Course from '../components/course'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import ReactPlayer from 'react-player'
import ReactStars from "react-rating-stars-component";
import { URL } from "../Configurations";
import { toast } from 'react-toastify'
import Dropdown from '../components/drop-down'
import '../styles/Pages/courseDetails.css'
import "../styles/Pages/pageLayout.css";

const CourseDetails = () => {
  const [course, setCourse] = useState([])
  const [avgRating, setAvgRating] = useState(0)
  const { state } = useLocation();
  const courseId = state.course.courseId
  const session = JSON.parse(sessionStorage.getItem('session'));
  const studentId = session.studentId;
  const role = session.role;
  const navigate=useNavigate();

  // getCourse Start
  const getCourse = () => 
  {
    axios.get(`${URL}/course-detail/${courseId}`).then((response) => 
    {
      const result = response.data
      if (result['status'] == 'success') {
        setCourse(result.data);
        console.log(result.data);
      }
      else 
        console.log("Error found");
      
    }
    )
}

// getCourse END

  function enrollment() {
    axios.get(`${URL}/student/enrollment/${courseId}/${studentId}`).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setCourse(result.data);
        console.log(result.data);
        toast.success("Successfully Enrolled for the course")
        navigate('/coursecontent',{state : {courseId : courseId}})
      }
      else 
      console.log("Error found");
    })
  }



useEffect(() => {
  const detail = getCourse();
  console.log('getting called allCourses')
}, [])


return (
  <div className='course-detail'>
    <Dropdown />
    <div className='gap'></div>
    <div ><h1>{course.courseTitle}</h1></div>
    <div><h6><ReactStars name="rating" activeColor="#FFA500" edit={false} value={state.course.avgRating} size={30} count={5} isHalf={true} />
      Ratting : {course.avgRating}</h6></div>
    {/* <div><h6><ReactStars name="rating" activeColor="#FFA500" edit={false} value={course.avgRating} size={30} count={5} isHalf={true}  />
            {course.avgRating}</h6></div> */}
    <div > <h5>Prerequisite :</h5><p>{course.prerequisite}</p> </div>
    <div><h5>Syallbus : </h5><p>{course.syallbus}</p>  </div>
    <div ><h5>Facalty :</h5><p>{course.facalty} </p></div>
    <div ><h5>CourseFee :</h5> {course.courseFee} </div>
    <div ><h5>Duration :</h5>{course.duration} Hrs </div>
    <div className='gap'></div>
    <div className='demo'><h4>Demo Videos Of Course</h4></div>
    <div className='gap'></div>
    <div ><h5>Demo video 1</h5> </div>
    <div ><ReactPlayer url={course.video1} /> </div>
    <div className='gap'></div>
    <div ><h5>Demo video 2</h5> </div>
    <div><ReactPlayer url={course.video2} /> </div>
    <div className='gap'></div>
    {role==="student"?<button className='enroll btn-primary' onClick={enrollment}>Enroll Here</button>
:null}
    <div className='gap'></div>
  </div>
)
}


export default CourseDetails