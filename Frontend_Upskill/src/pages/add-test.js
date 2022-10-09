// import "../styles/pages/test.css"
import Dropdown from '../components/drop-down'
import { Navigate, useLocation, useNavigate } from 'react-router'
import { useState } from 'react'
import axios from "axios"
import { toast } from 'react-toastify'
import "../styles/Pages/add-test.css"

const Test = (props) => {
    const { state } = useLocation()

    const {c}=state;
    console.log(c);
    const navigate = useNavigate();
    const session = JSON.parse(sessionStorage.getItem('session'));
    const id=session.courseId;
    const [question, setQuestion] = useState("");
    const [option1, setOption1] = useState("");
    const [option2, setOption2] = useState("");
    const [option3, setOption3] = useState("");
    const [option4, setOption4] = useState("");
    const [answer, setAnswer] = useState("");
    
   
    
   
    function addTest(){

        const body = {
            question,
            option1,
            option2,
            option3,
            option4,
            answer
            
        };
        console.log(body);
        const url=`http://localhost:8081/lecturer/addtest/${c.courseId}`
        axios.post(url,body).then((response)=>{
            const result=response.data;
            console.log(result);
            setQuestion("");
                setOption1("");
                setOption2("");
                setOption3("");
                setOption4("");
                setAnswer("");
            if(result["status"]=="success"){
                toast.success("Test added successfull")
                // navigate("/my-account")
                            }
            else {
                toast.error("Failed try Again");
                console.log(result["error"])
            }
        })
    }

    return (
        <div style={{marginLeft:75}}>
             <Dropdown />
            <div >
                <h3 className="title text-center">AddTest</h3>
                <div>
                    <br />
                    <br />
                    <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Question:</label>
                    <div class="col-sm-10">
                    <textarea value={question} onChange={(e) => {
                        setQuestion(e.target.value);
                    }}type="text" class="form-control" rows="4" />
                    </div>

                    <div>
                        <br />
                        <br />

                        <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Option1</label>
                        <div class="col-sm-10">
                            <input value={option1} onChange={(e) => {
                        setOption1(e.target.value);
                    }}type="text" class="form-control" />
                        </div>
                        <br />
                        <br />
                        <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Option2</label>
                        <div class="col-sm-10">
                            <input value={option2} onChange={(e) => {
                        setOption2(e.target.value);
                    }}type="text" class="form-control" />
                        </div>
                        <br />
                        <br />
                        <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Option3</label>
                        <div class="col-sm-10">
                            <input value={option3} onChange={(e) => {
                        setOption3(e.target.value);
                    }}type="text" class="form-control" />
                        </div>
                        <br />
                        <br />
                        <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Option4</label>
                        <div class="col-sm-10">
                            <input value={option4} onChange={(e) => {
                        setOption4(e.target.value);
                    }}type="text" class="form-control" />
                        </div>
                        <br />
                        <br />
                        <label class="control-label col-sm-2" for="exampleFormControlTextarea1">Answer</label>
                        <div class="col-sm-10">
                            <input value={answer} onChange={(e) => {
                        setAnswer(e.target.value);
                    }}type="text" class="form-control" />
                        </div>
                       
                        

                        <div className='gap'></div>
                        <div> <button className='btn-primary addtestbtn'onClick={addTest} >Submit</button>
                       <button className='btn btn-dark backbtn'onClick={()=>{navigate("/select-course")}} >Back</button></div>
                        <div className='gap'></div>


                    </div>
                </div>
            </div>
        </div>

    )
}

export default Test