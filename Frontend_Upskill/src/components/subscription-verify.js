import React, { useEffect } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { useState } from 'react'
import { URL } from "../Configurations";
const SubscriptionVerify = () => {

   const lecturerId= sessionStorage.lecturerId
   const [data, setData] = useState(0)
   const navigate =useNavigate();
    
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
    SubscriptionVerify()
    console.log('SubscriptionVerify called')
  }, [])

  export default SubscriptionVerify