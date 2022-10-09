import React from 'react';
import axios from 'axios'
import { toast } from 'react-toastify'
import { Navigate, useNavigate } from 'react-router';
import { useEffect } from 'react';
import { useState } from 'react';
import { URL } from "../Configurations";

const Removeplan = ()=> {

    const navigate =useNavigate()
    const lecturerId=sessionStorage.lecturerId
    const[data , setData] =useState("");
    const body = {
        lId: lecturerId,
        snId: null,
    };

    console.log(body);

    const detail = () => {
        axios.get(`${URL}/subscription-detail/${lecturerId}`).then((response) => {
          const result = response.data
          if (result['status'] == 'success') {
            console.log(result.data.planStatus);
            setData(result.data.planStatus);
          }
          else {
            console.log("Error found");
          }
        })
      }
    
      useEffect(() => {
        detail()
        console.log('getting called allCourses')
      }, [])
    
      if(data==="expire"){
      const url = `http://localhost:8081/remove-plan`;
        axios.post(url, body).then((response) => {
            const result = response.data;
            console.log(result);
            if (result["status"] == "success") {
                toast.success("removed plan !!!")
                navigate("/my-account")
            }
            else {
                toast.error("Failed try Again");
                console.log(result["error"])
            }
        })
      }

    return (
        <>
        </>
    )
}

export default Removeplan




