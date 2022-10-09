import React, { useEffect } from 'react'
import axios from 'axios'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import { Navigate, useLocation, useNavigate } from 'react-router'
import Dropdown from '../components/drop-down'
import { toast } from 'react-toastify'
import { URL } from "../Configurations";
import "../styles/Pages/add-course.css"



const AddCourse = () => {
    // const { state } = useLocation()
    const navigate = useNavigate();
    const session = JSON.parse(sessionStorage.getItem('session'));
    const id=session.lecturerId;
    const [courseTitle, setCourseTitle] = useState("");
    const [courseFee, setCourseFee] = useState("");
    const [duration, setDuration] = useState("");
    const [prerequisite, setPrerequisite] = useState("");
    const [syallbus, setSyallbus] = useState("");
    const [tags, setTags] = useState("");
    const [url1, setUrl1] = useState("");
    const [name1, setName1] = useState("");
    const [url2, setUrl2] = useState("");
    const [name2, setName2] = useState("");
   
    


    function course () {
       
               
        const body = {
            courseTitle,
            courseFee,
            duration,
            prerequisite,
            syallbus,
            tags,
            videoName1:name1,
            videourl1:url1,
            videoName2:name2,
            videourl2:url2
        };

        console.log(body);

        const url = `${URL}/course/addcourse/${id}`;

        axios.post(url, body).then((response) => {
            const result = response.data;
            console.log(result);
            if (result["status"] == "success") {
                toast.success("Course added successfully")
                navigate("/my-account")
            }
            else {
                toast.error("Failed try Again");
                console.log(result["error"])
            }
        });
    }





    return (
        <div className='add-course'>
            <Dropdown />

            <h1 className='text-center'>Add Course</h1>
            <div className='gap'></div>
            <div>
                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">CourseTitle</label>
                <div class="col-sm-10">
                    <input onChange={(e) => {
                        setCourseTitle(e.target.value);
                    }}
                        type="text" class="form-control" />
                </div>

                <label class="control-label col-sm-2" for="emexampleFormControlTextarea1ail">courseFee</label>
                <div class="col-sm-10">
                    <input onChange={(e) => {
                        setCourseFee(e.target.value);
                    }}
                        type="text" class="form-control" />
                </div>

                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">duration</label>
                <div class="col-sm-10">
                    <input onChange={(e) => {
                        setDuration(e.target.value);
                    }}
                        type="text" class="form-control" />
                </div>

                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">prerequisite</label>
                <div class="col-sm-10">
                    <textarea onChange={(e) => {
                        setPrerequisite(e.target.value);
                    }}

                        type="text" class="form-control" rows="4"/>
                </div>

                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">syallbus</label>
                <div class="col-sm-10">
                    <textarea onChange={(e) => {
                        setSyallbus(e.target.value);
                    }}
                        type="text" class="form-control" rows="4" />
                </div>

                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">tags</label>
                <div class="col-sm-10">
                    <textarea onChange={(e) => {
                        setTags(e.target.value);
                    }}

                        type="text" class="form-control" rows="4"/>

                </div>

                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Demo Video 1 Name</label>
                <div class="col-sm-10">
                    <input onChange={(e) => {
                        setName1(e.target.value);
                    }}
                        type="text" class="form-control" />
                </div>
                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Demo Video 1 URL</label>
                <div class="col-sm-10">
                    <input onChange={(e) => {
                        setUrl1(e.target.value);
                    }}
                        type="text" class="form-control" />
                        
                </div>

                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Demo Video 2 Name</label>
                <div class="col-sm-10">
                    <input onChange={(e) => {
                        setName2(e.target.value);
                    }}
                        type="text" class="form-control" />
                </div>
                <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Demo Video 2 URL</label>
                <div class="col-sm-10">
                    <input onChange={(e) => {
                        setUrl2(e.target.value);
                    }}
                        type="text" class="form-control" />
                        
                </div>

                <div className='gap'></div>
                <div> <button className='btn-primary addcoursebtn' onClick={course}>Submit</button></div>
                <div className='gap'></div>

            </div>
        </div>
    )
}

export default AddCourse