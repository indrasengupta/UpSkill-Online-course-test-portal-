import React,{useEffect} from 'react'
import Course from '../components/course'
import axios from 'axios'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import '../styles/Pages/homePage.css'
import Dropdown from '../components/drop-down'
//import '../styles/component/courseComponent.css'
import Removeplan from '../components/remove-plan'
import { toast } from 'react-toastify'
import { useLocation } from 'react-router'
import { URL } from "../Configurations";



const Home = ()=>{

const { loginStatus }=sessionStorage;
const { role }=sessionStorage;
const { firstName }=sessionStorage;
  const [courses , setCourses]=useState([] )

 const allCourses=()=>{
  axios.get(`${URL}/courses`).then((response) => {
    const result = response.data
    if (result['status'] == 'success') {
      console.log("before");
      console.log(result.data);
      setCourses(result.data);
    }
    else {
      console.log("Error found");
    }
  })
 }


 


 useEffect(() => {
  allCourses()
  // if(state.course!=null){console.log("sucessfully delete course : "+courseId)}
  
  console.log('getting called allCourses')
}, [])

    return(
    
        <div className='layout viewport' >
          <h2 className='home-course-title'>Courses</h2>
          
         <div className='hello-user'><h5 > {role==="lecturer" ? <Removeplan /> : null}
            {loginStatus ? <h5>Hello, {firstName }</h5>  : null}</h5></div>
          <Dropdown />
          <div className='gap'></div>
        <div className='course-comonent-possition'>{courses.length > 0 ? courses.map((item)=><Course course={item}> </Course>):"No courses "}</div>
        </div>
    
    )

}

export default Home