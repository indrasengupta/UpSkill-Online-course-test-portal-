import React, { useEffect } from 'react'
import axios from 'axios'
import { useState } from 'react'
import { toast } from 'react-toastify'
import Course from '../components/course'
import { Link } from 'react-router-dom'
import Subscription from './subscription'
// import '../styles/pages/subscription-detail.css'
import LeftNavbar from '../components/left-navbar'
import { Navigate, useNavigate } from 'react-router'
import Dropdown from '../components/drop-down'
import { URL } from "../Configurations";

const SubscriptionDetail = () => {
  const { loginStatus } = sessionStorage;
  const { role } = sessionStorage;
  const { firstName } = sessionStorage;
  const { lecturerId } = sessionStorage;

  const [data, setData] = useState(0)
const navigate =useNavigate();

  const detail = () => {
    axios.get(`${URL}/subscription-detail/${lecturerId}`).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        console.log(result.data);
        setData(result.data);
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

  return (
    <div>
      <Dropdown />
      <LeftNavbar />
      <h1 className='text-center'>Subscription Details</h1>
      <div className='gap'></div>
      <div className='text-center'>{data == null ? <div><h3>No subscription available ,please purchase plan </h3>
        <div><Subscription /></div>
      </div>
        :
        <div className='text-center'><h3>Your plan details are as follows </h3>
          <div className='gap'></div>
          <div>
            <h5>PlanName : {data.planName}</h5>
            <h5> ActivationDate : {data.activationDate}</h5>
            <h5>PlanCost : {data.planCost}</h5>
            <h5>PlanDuration : {data.planDuration}</h5>
            <h5>DaysLeft : {data.daysLeft}</h5>
            <h5> PlanStatus : {data.planStatus}</h5>
          </div>
        </div>
      }</div>


    </div>
  )
}

export default SubscriptionDetail