import React from 'react'
import { Navigate, useNavigate } from 'react-router'

const SubscriptionPlan=({subscription})=>{

const navigate= useNavigate();

    return(
        <div >

        <div className="container">
            <div className="row">
                <div className="ab col-4">
                    {subscription.snPlan} 
                </div>
                <div style={{color:'red' , fontWeight : 'bold'}} className="col-4">
                {subscription.snDuration} Days
                </div>
                <div  className="col-4">
                <button onClick={() => {
                navigate('/buy-plan', { state: { subscription: subscription } })
              }} >Select</button>
                </div>
            </div>
        </div>
        </div>
    )
}

export default SubscriptionPlan;