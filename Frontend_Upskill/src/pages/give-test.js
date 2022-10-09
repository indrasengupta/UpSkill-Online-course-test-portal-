import React, { useEffect } from 'react'
import axios from 'axios'
import { useState } from 'react'
import Dropdown from '../components/drop-down';
import { URL } from "../Configurations";
import Question from '../components/question-comonent';
import { toast } from 'react-toastify';
import LeftNavbar from '../components/left-navbar';
import { useLocation } from 'react-router-dom';



const GiveTest=()=>{
  console.log("Inside GetTEST")
    const[questions,setQuestions]=useState([])
    const[submit,setSubmit]=useState(0)
    const[correct,setCorrect]=useState(0)
    const session = JSON.parse(sessionStorage.getItem('session'));
  const studentId = session.studentId;
  
  const {state}=useLocation();
const courseId=state.id;
   
   
// GIVE TEST
    function test(){
      axios.get(`${URL}/student/test/${courseId}`).then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          console.log(result.data);
          setQuestions(result.data);
        }
        else {
          console.log("Error found");
        }
      })
    
    }
   
    // Update Result
    function studentResult(){
     
      axios.put(`${URL}/student/result/${courseId}/${studentId}/${correct}`).then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
        toast.success("result updated")
        }
        else {
          console.log("Error found");
        }
      })
    
    }
    
    function parent(choice){
      console.log("Inside function parent")
choice?setCorrect(correct+1):setCorrect(correct+0)


    }
    


      useEffect(() => {
        console.log("Parent Useeffect")
        test()
      }, [])
    
    
      function submitTest(){
        console.log("Inside function Submit Test")
        setSubmit(1);
        const res= correct>3?"You have Succesfully Passed!!!":"You have Failed!!!"
        document.getElementById("res").innerHTML=res
        document.getElementById("result").innerHTML="Result = "+correct+"0 %"
        document.getElementById("b").disabled=true      
        studentResult();
        
      }



    return(
     <div>
       <Dropdown/>
        <h1 className="text-center">TEST</h1>
            <div><h4>Please choose appropriate option</h4></div>
            <div id='res'><h4></h4></div>
            <div id='result'><h4></h4></div>
            <div className='gap'></div>
        <div> 
        {<div>{questions.length > 0 ? questions.map((item)=> <Question question={item} submit ={submit} parent={parent}> </Question>):"No Questions "}</div>}
      <div className='gap'></div>
      <button  id='b' className='btn-primary submit' onClick={submitTest}>Submit Test & check Answer</button>
      </div>
      <div className='gap'></div>
      
      
     </div>  
     
    )
}

export default GiveTest