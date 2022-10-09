import React, { useEffect } from 'react';

import Dropdown from '../components/drop-down';
import axios from 'axios'
import { useState } from 'react'
import { URL } from "../Configurations";
import SelectCourseCompo from '../components/selectCourseCompo';
// import "../styles/component/selectCourseCompo.css"


const SelectCourse = () => {
    const [courses , setCourses]=useState([] )
    const session = JSON.parse(sessionStorage.getItem('session'));
    const id=session.lecturerId;
    
    const allCourses=()=>{
        axios.get(`${URL}/lecturer/courses/${id}`).then((response) => {
          const result = response.data
          console.log(result);
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
        
        
        console.log('getting called allCourses')
      }, [])
    return (
        <div className='selectCourseCompo'>
            <Dropdown />
            <div>
            </div>
            <div className=" text-center onee"><h2>Available Courses</h2></div>
            {courses.length > 0 ? courses.map((item) => <SelectCourseCompo course={item}> </SelectCourseCompo>) : "No courses "}
        
        </div >
    )
}

 export default SelectCourse