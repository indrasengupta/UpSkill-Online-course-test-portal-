
import { useState, useEffect } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useLocation, useNavigate } from "react-router";
// import "./index.css"
import { URL } from "../Configurations";
import StudCourse from "../components/student-course";




const StudentCourse = () => {
  const session = JSON.parse(sessionStorage.getItem('session'));
  const studentId = session.studentId;

  const [course, setCourse] = useState([])
  const navigate = useNavigate()

  const loadStudentCourse = () => {
    const url = `${URL}/student/courses/${studentId}`
    axios.get(url).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setCourse(result['data'])

        console.log(result.data)

      }
      console.log(result.data.error)
    })
  }

  useEffect(() => {
    loadStudentCourse()
  }, [])

  return (
    <div className="my-courses">
      <div className="heading-my-courses"><h1>My Course</h1></div>
      <table  className="table table-striped">
        <thead>
          <tr>
            <th>Course Id</th>
            <th>Course Title</th>
            <th>Duration</th>
            <th>Course Fee</th>
            <th>Course Prerquisites</th>
            <th>Syllabus</th>
            <th>Tags</th>
          </tr>
        </thead>
        <tbody>
        {course.map((course) => {
            return <StudCourse course={course} />
          })}
        
        </tbody>
      </table>
      <div>
        <button className="btn btn-success float-end"
          onClick={() => {
            navigate('/my-account')

          }}
        >
          Back
        </button>
      </div>
    </div>
  )
}


export default StudentCourse