import React from 'react'
import ReactStars from "react-rating-stars-component";
import { toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import { Navigate, useNavigate } from 'react-router-dom';


const StudCourse = ({course}) => {

   const navigate=useNavigate();





    return (
        <tr>
         
          <td>{course.courseId}</td>
          <td><button onClick={()=>{navigate("/coursecontent",{state:{courseId:course.courseId}})}}>{course.courseTitle}</button></td>
          <td>{course.duration}</td>
          <td>{course.courseFee}</td>
          <td>{course.prerequisite}</td>
          <td>{course.syallbus}</td>
          <td>{course.tags}</td>
          

        </tr>
      )
    }
    


export default StudCourse