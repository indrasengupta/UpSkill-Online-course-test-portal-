import React,{useEffect} from 'react'
import { useLocation, useNavigate } from 'react-router'
import axios from 'axios'
import { URL } from "../Configurations";




const DeleteCourse=({course})=>{

    const { state } = useLocation();
    const navigate=useNavigate();
    const removeCourse=()=>{
    
    // const  courseId  = state.course.courseId
    const  courseId  = course.courseId
    console.log(courseId)

    axios.get(`${URL}/course-remove/${courseId}`).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
          navigate("/home");
        console.log("Course deleted"+courseId);

        
      }
      else {
        console.log("Error found");
      }
    })
   }
  
   useEffect(() => {
    removeCourse();
     console.log('course deleted')
   }, [])
   

return(
    <>
    </>
)

}

export default DeleteCourse