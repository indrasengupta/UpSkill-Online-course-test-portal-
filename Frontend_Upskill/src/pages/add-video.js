import React, { useEffect } from 'react'
import axios from 'axios'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import { Navigate, useLocation, useNavigate } from 'react-router'
import Dropdown from '../components/drop-down'
import { toast } from 'react-toastify'
import { URL } from "../Configurations";
import "../styles/Pages/add-test.css"



const AddVideo = () => {
    const [name, setName] = useState("");
    const [url, setUrl] = useState("");
    
    const { state } = useLocation()
    const {c}=state;
const navigate=useNavigate()
    function video() {


        const body = {
            courseId:c.courseId,
            vName: name,
            video: url,
        };

        console.log(body);
        
        const urls = `${URL}/lecturer/addvideos`;
        
        axios.post(urls, body).then((response) => {
            const result = response.data;
            console.log(result);
            if (result["status"] == "success") {
                toast.success("Course added successfully")
            }
            else {
                toast.error("Failed try Again");
                console.log(result["error"])
            }
        });
    }






    return (
        <div style={{marginLeft:75}}>
            <h1 className='text-center'>Add Videos Here</h1>
            <div className='gap'></div>

            <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Video Name</label>
            <div class="col-sm-10">
                <input onChange={(e) => {
                    setName(e.target.value);
                }}
                    type="text" class="form-control" />
            </div>
            <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Video URL</label>
            <div class="col-sm-10">
                <input onChange={(e) => {
                    setUrl(e.target.value);
                }}
                    type="text" class="form-control" />
                <div className='gap'></div>
            </div>
            <button className='btn-primary addtestbtn' onClick={video}>Add video</button>
            <button className='btn btn-dark backbtn'onClick={()=>{navigate("/select-course")}} >Back</button>
        </div>
    )
}



export default AddVideo