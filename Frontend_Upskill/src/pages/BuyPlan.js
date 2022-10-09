import React, { useEffect } from 'react'
import axios from 'axios'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import { Navigate, useLocation, useNavigate } from 'react-router'
import Dropdown from '../components/drop-down'
import { toast } from 'react-toastify'
import { URL } from "../Configurations";

const BuyPlan = () => {
    const navigate = useNavigate();
    const session = JSON.parse(sessionStorage.getItem('session'));
    const { state } = useLocation();
    console.log(state.subscription)
const l=session.lecturerId;
const s=state.subscription.snId;
console.log("##########lec"+l+"  plan  "+s);
    
    function buy() {
        const body = {
            lId: l,
            snId: s,
        };

        console.log(body);

        const url = `${URL}/buy-plan`;

        axios.post(url, body).then((response) => {
            const result = response.data;
            console.log(result);
            if (result["status"] == "success") {
                toast.success("purchase done !!!")
                navigate("/my-account")
            }
            else {
                toast.error("Failed try Again");
                console.log(result["error"])
            }
        });
    }


   


return (
    <div>
        <Dropdown />

        <h4 className='text-center'>Enter Details Bellow</h4>
        <div className='gap'></div>
        <div>
            <label class="control-label col-sm-2" for="email">Name:</label>
            <div class="col-sm-10">
                <input type="text" readOnly="true" class="form-control" value={session.firstName + " " + session.lastName} />
            </div>

            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input type="email" readOnly="true" class="form-control" value={session.email} />
            </div>

            <label class="control-label col-sm-2" for="email">Lecturer Id:</label>
            <div class="col-sm-10">
                <input type="text" readOnly="true" class="form-control" value={session.lecturerId} />
            </div>

            <label class="control-label col-sm-2" for="email">Plan:</label>
            <div class="col-sm-10">
                <input type="text" readOnly="true" class="form-control" value={state.subscription.snPlan} />
            </div>

            <label class="control-label col-sm-2" for="email">Amount:</label>
            <div class="col-sm-10">
                <input type="text" readOnly="true" class="form-control" value={state.subscription.snAmount} />
            </div>
            <div className='gap'></div>
            <div> <button className='btn-primary' onClick={buy}>Submit</button></div>

        </div>
    </div>
)
}

export default BuyPlan