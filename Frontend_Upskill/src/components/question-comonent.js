import React, { useEffect } from 'react'
import axios from 'axios'
import { useState } from 'react'
import { URL } from "../Configurations";
// import '../styles/components/question-component.css'



const Question = ({ question, submit ,parent}) => {
    console.log("Inside Question component")           

    const [score, setScore] = useState(0);                 
    console.log("Score = "+score)     
    function viewanswer() {
        document.getElementById(question.qId).innerHTML = question.answer

    }

    function one() {
        const value1 = document.getElementById(question.qId + 100).value
        if (value1 === question.answer) {
            console.log("Before update Score is  "+score)                  
            setScore(score + 1);                                                         
            console.log("After update Score is  "+score)                  
        }     

    }                                           

    function two() {
        const value2 = document.getElementById(question.qId + 200).value
        if (value2 === question.answer)
        score?setScore(0):setScore(score + 1);
    }

    function three() {
        const value3 = document.getElementById(question.qId + 300).value
        if (value3 === question.answer)
        score?setScore(0):setScore(score + 1);
    }

    function four() {
        const value4 = document.getElementById(question.qId + 400).value
        if (value4 === question.answer)
            score?setScore(0):setScore(score + 1);
    }


     
     useEffect(() => {
        console.log("useeffect Before sending data to parent")         
        score===1?parent(1):parent(0);                                  
        console.log("useeffect After sending data to parent")         
      },[score])                
      

    return (
        <div>
            <div><h5>Question {question.qId}: {question.question} </h5></div>
            <div><input id={question.qId + 100} type="radio" name={question.qId} value={question.option1} onClick={one} />
                <label className='space' ><h5>{question.option1}</h5></label>
            </div>

            <div><input id={question.qId + 200} type="radio" name={question.qId} value={question.option2} onClick={two} />
                <label className='space' ><h5>{question.option2}</h5></label>
            </div>

            <div><input id={question.qId + 300} type="radio" name={question.qId} value={question.option3} onClick={three} />
                <label className='space'><h5>{question.option3}</h5></label>
            </div>

            <div><input id={question.qId + 400} type="radio" name={question.qId} value={question.option4} onClick={four} />
                <label className='space' ><h5>{question.option4}</h5></label>
            </div>

            <button onClick={viewanswer}>Check Here</button>
            <div id={question.qId}></div>
            {submit ? <div id='answer'>{question.answer}</div> : null}
            <div className='gap'></div>

        </div>
    )
}

export default Question