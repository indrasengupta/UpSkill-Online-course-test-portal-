import React from 'react'
import ReactStars from "react-rating-stars-component";
import { toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'



const LectCourse = ({course}) => {

   





    return (
        <tr>
         
          <td>{course.courseId}</td>
          <td>{course.courseTitle}</td>
          <td>{course.duration}</td>
          <td>{course.courseFee}</td>
          <td>{course.prerequisite}</td>
         

        </tr>
      )
    }
    


export default LectCourse