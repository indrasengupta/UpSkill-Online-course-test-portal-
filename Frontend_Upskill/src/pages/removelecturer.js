import axios from "axios"
import { toast } from "react-toastify";
import { URL } from "../Configurations";
import LecturerList from "../components/lecturerList";
import Dropdown from "../components/drop-down";
import { useLocation,useNavigate } from "react-router";
import "../styles/component/profile.css"
import "../styles/Pages/remove-lecturer.css"
import "../styles/component/drop-down.css"



import { useEffect } from "react";
import { useState } from "react";

const RemoveLecturer = () => {
    

    const session = JSON.parse(sessionStorage.getItem('session'));
    const adminName =session.firstName
    
    const navigate=useNavigate();
    const [lecturerList,setLecturerList]=useState([]);



    function lecturers() {
        axios.get(`${URL}/admin/all-lecturer`).then((response) => {
            const result = response.data
            
            if (result['status'] == 'success') {
               
                setLecturerList(result.data);
                console.log(lecturerList)
            }
            else {
                console.log("Error found");
            }

        })
    }

    




    useEffect(() => {
        lecturers()
    }, [])
    return (

        <div style={{marginLeft:75}}>
            <div>
                <h3>Remove Lecturer</h3>
            </div>
            <br/>

            <div className='parent'>
               
                 <h5>Hello, {adminName}</h5>
                <div className="dropdown"><Dropdown /></div>
                <div className=" text-center"><h2>Lecturer List</h2></div>
                <table className="table table-striped">
          <thead>
            <tr>
              <th>lecturerId</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Remove</th>
            </tr>
          </thead>
          <tbody>
               {lecturerList.length > 0 ? lecturerList.map((lecturer) => <LecturerList lecturer={lecturer}> </LecturerList>) : "No Lecturers "}
          </tbody>
        </table>
               
            </div>

        </div>
        )
}
export default RemoveLecturer