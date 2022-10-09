import { useState , useEffect} from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useLocation, useNavigate } from "react-router";
// import "./index.css"
 import LectCourse from "../components/lecturer-course-component";
 import { URL } from "../Configurations";
const LecturerCourse = () => {
    
    const [course, setCourse] = useState([])
    const session = JSON.parse(sessionStorage.getItem('session'));
    const lecturerId = session.lecturerId;
    const navigate = useNavigate()
  
    const loadLecturerCourse = () => {
     const url = `${URL}/lecturer/courses/${lecturerId}`
      axios.get(url).then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          setCourse(result['data'])
          console.log(result.data)
         
        }
      })
    }
  
    useEffect(() => {
      loadLecturerCourse()
    }, [])

    return (
      <div>
        <h1 className="title">My Course</h1>
  
    
       
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Course Id</th>
              <th>Course Title</th>
              <th>Duration</th>
              <th>Course Fee</th>
              <th>Course Prerquisites</th>
            </tr>
          </thead>
          <tbody>
            {course.map((course) => {
              return <LectCourse course={course} />
            })}
          </tbody>
        </table>
        <div >
            <button  className="btn btn-success float-end"
              onClick={() => {
               
                navigate('/my-account' )
                
              }}
             
            >
               Back
            </button>
          </div>
      </div>
      
    )
  }


export default LecturerCourse