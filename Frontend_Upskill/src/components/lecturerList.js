import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router';
import { URL } from "../Configurations";
import { useState } from 'react/cjs/react.production.min';

const LecturerList = ({ lecturer }) => {
    const navigate = useNavigate();
    console.log(lecturer);
    console.log(lecturer.lecturerId);


    function remove() {

        axios.delete(`${URL}/admin/removelecturer/${lecturer.lecturerId}`).then((response) => {

            const result = response.data
            if (result["status"] == "success") {
                toast.success("removed lecturer!!!")
                //navigate("/")
                window.location.reload();
            }
            else {
                toast.error("Failed try Again")

            }
        })
    }
    return (
        
                <tr>
                    <td> {lecturer.lecturerId}</td>
                    <td>{lecturer.firstName}</td>
                    <td>{lecturer.lastName}</td>
                    <td><button className='btn btn-primary' onClick={remove}>Delete</button></td>
                </tr>


    )
}
export default LecturerList