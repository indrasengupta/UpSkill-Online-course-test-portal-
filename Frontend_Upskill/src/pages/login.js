import "../styles/Pages/loginPage.css";
import "../styles/Pages/pageLayout.css";
import { Link } from "react-router-dom";
import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import { URL } from "../Configurations";

const Login = () => {
  sessionStorage.clear();
  const [path, setPath] = useState("student");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  function setStudentUrl() {
    setPath("student");
  }
  function setLecturerUrl() {
    setPath("lecturer");
  }
  function setAdminUrl() {
    setPath("admin");
  }

  const navigate = useNavigate();

  const onSubmit = (e) => {
    e.preventDefault();
    /* console.log("refresh prevented"); */
  };

  function loginUser() {
    if (email.length == 0) {
      toast.warning("Please enter email");
    } else if (password.length == 0) {
      toast.warning("Please enter password");
    } else {
      const body = {
        email,
        password,
      };

      /* console.log(email);
      console.log(password); */

      // url to call the api
      const url = `${URL}/${path}/login`;
      /* console.log(url); */

      // http method: post
      // body: contains the data to be sent to the API
      axios.post(url, body).then((response) => {
        // get the data from the response
        const result = response.data;
        console.log(result);
        if (result["status"] == "success") {
          sessionStorage.setItem("session", JSON.stringify(result.data));
          toast.success("Successfully Logged In");
          const { role, firstName } = result['data']
          sessionStorage['role'] = role
          sessionStorage['firstName'] = firstName
          sessionStorage['loginStatus'] = 1
          // navigate to the login page according to path
          if (path == "student") {
            const { studentId } = result['data']
            sessionStorage['studentId'] = studentId
            /* console.log(sessionStorage['id']);
            console.log(sessionStorage['loginStatus']); */
            navigate("/home");
          } else if (path == "lecturer") {
            const { lecturerId } = result['data']
            sessionStorage['lecturerId'] = lecturerId
            navigate("/home");
          } else if (path == "admin") {
            const { adminId } = result['data']
            sessionStorage['adminId'] = adminId
            sessionStorage['loginStatus'] = 1
            navigate("/home");
          }
        } else {
          toast.error(result["error"]);
        }
      });
    }
  }
  return (
    <div className="bg login">
      <div className="row">
        <div className="col-md-4 col-sm-4 col-xs-12"></div>
        <div className="col-md-4 col-sm-4 col-xs-12">
          <form className="form-container" onSubmit={onSubmit}>
            {path==="student"?<h1 className="tittle">Student Login</h1>:path==="lecturer"?<h1 className="tittle">Lecturer Login</h1>:<h1 className="tittle">Admin Login</h1>}
            <div className="row">
              <ul className="nav nav-tabs">
                <li className="nav-item">
                  <a
                    className="nav-link a-style "
                    aria-current="page"
                    href="#"
                    onClick={setStudentUrl}
                  >
                    Student
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    className="nav-link a-style "
                    aria-current="page"
                    href="#"
                    onClick={setLecturerUrl}
                  >
                    Lecturer
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    className="nav-link a-style "
                    aria-current="page"
                    href="#"
                    onClick={setAdminUrl}
                  >
                    Admin
                  </a>
                </li>
              </ul>
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputEmail1" className="form-label">
                Email
              </label>
              <input
                type="email"
                className="form-control input-style"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Email"
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputPassword1" className="form-label">
                Password
              </label>
              <input
                type="password"
                className="form-control input-style"
                id="exampleInputPassword1"
                placeholder="Password"
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
              />
            </div>
            <button
              type="submit"
              className="btn btn-outline-primary w-100"
              onClick={loginUser}
            >
              Login
            </button>
          </form>
          <div className="float-container">
            <div className="float-child">
              <div>No account yet?</div>
            </div>

            <div className="float-child">
              <div className="float-none">
                <div className="btn-group " role="group">
                  <button
                    type="button"
                    className="btn btn-primary btn-sm dropdown-toggle"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    Signup as
                  </button>
                  <ul className="dropdown-menu" aria-labelledby="btnGroupDrop1">
                    <li>
                      {/* <a className="dropdown-item">Student</a> */}
                      <Link to="/studentsignup">Student</Link>
                    </li>
                    <li>
                      {/* <a className="dropdown-item">Lecturer</a> */}
                      <Link to="/lecturersignup">Lecturer</Link>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="col-md-4 col-sm-4 col-xs-12"></div>
      </div>
    </div>
  );
};

export default Login;
