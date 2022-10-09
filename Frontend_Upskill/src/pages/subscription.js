import React, { useEffect } from 'react'
import  SubscriptionPlan from '../components/subscriptionPlan'
import axios from 'axios'
import { useState } from 'react'
// import '../styles/pages/subscription.css'
import Dropdown from '../components/drop-down'
import { URL } from "../Configurations";

const Subscription=()=>{

    const [subscriptionPlans , setSubscriptionPlans]=useState([ ] )
    
     const plans =()=>{

        axios.get(`${URL}/subscription`).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
              console.log(result.data);
              setSubscriptionPlans(result.data);
            }
            else {
              console.log("Error found");
            }
          })
     }

     useEffect(() => {
        plans()
        console.log('getting called subscription')
      }, [])

    return(
        <div>
          <Dropdown />
            <div className='gap text-center'>
                <h1>All Plans For Lecturer</h1>
            </div>
            <div>
            {subscriptionPlans.length > 0 ? subscriptionPlans.map((item)=><SubscriptionPlan subscription={item}> </SubscriptionPlan>):"No Plans "}
       
            </div>
        </div>
    )
}

export default Subscription;