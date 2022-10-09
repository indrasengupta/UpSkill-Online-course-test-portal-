import { Link } from 'react-router-dom'
import { useState } from 'react'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { URL } from '../Configurations'
import "../styles/Pages/signup.css";

const LecturerSignup = () => {
  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const [gender, setGender] = useState('')
  const [phone, setPhone] = useState('')
  const [qualification, setQualification] = useState('')
  const [experience, setExperience] = useState('')

  // used to navigate from one component to another
  const navigate = useNavigate()

  // used to Prevent Basic React Form Submit From Refreshing the Entire Page
  const onSubmit = (e) => {
    e.preventDefault();
    console.log("refresh prevented");
  };

  const signupLecturer = () => {
    if (firstName.length == 0) {
      toast.warning('Please enter first name')
    } else if (lastName.length == 0) {
      toast.warning('Please enter last name')
    } else if (email.length == 0) {
      toast.warning('Please enter email')
    } else if (password.length == 0) {
      toast.warning('Please enter password')
    } else if (confirmPassword.length == 0) {
      toast.warning('Please confirm your password')
    } else if (password != confirmPassword) {
      toast.warning('Password does not match')
    } else {
      const body = {
        firstName,
        lastName,
        email,
        password,
        gender,
        phone,
        qualification,
        experience
      }

      /* console.log(firstName);
      console.log(lastName);
      console.log(email);
      console.log(password);
      console.log(gender);
      console.log(phone);
      console.log(qualification);
      console.log(experience); */

      // url to call the api
      const url = `${URL}/lecturer/signup`

      // http method: post
      // body: contains the data to be sent to the API
      axios.post(url, body).then((response) => {
        // get the data from the response
        const result = response.data
        console.log(result)
        if (result['status'] == 'success') {
          toast.success('Successfully signed up new user')

          // navigate to the login page
          navigate('/login')
        } else {
          toast.error(result['error'])
        }
      })
    }
  }
  return (
    <div className="bg signup">
      <div className="row">
        {/* <div className="col-md-4 col-sm-4 col-xs-12"></div> */}
        <div className="col"></div>
        <div className="col-5">
          <form className="form-container" onSubmit={onSubmit}>
            <h1 className="tittle">Lecturer Signup</h1>
            <hr/>
            <div className="row">
              <div className="col class-style">
                <div className="mb-3">
                  <label htmlFor="s-fname" className="label-control">
                    First Name
                  </label>
                  <input
                    onChange={(e) => {
                      setFirstName(e.target.value);
                    }}
                    type="text"
                    id="s-fname"
                    className="form-control"
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="s-lname" className="label-control">
                    Last Name
                  </label>
                  <input
                    onChange={(e) => {
                      setLastName(e.target.value);
                    }}
                    type="text"
                    id="s-lname"
                    className="form-control"
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="s-eaddress" className="label-control">
                    Email Address
                  </label>
                  <input
                    onChange={(e) => {
                      setEmail(e.target.value);
                    }}
                    type="email"
                    id="s-eaddress"
                    className="form-control"
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="s-pass" className="label-control">
                    Password
                  </label>
                  <input
                    onChange={(e) => {
                      setPassword(e.target.value);
                    }}
                    type="password"
                    id="s-pass"
                    className="form-control"
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="s-cpass" className="label-control">
                    Confirm Password
                  </label>
                  <input
                    onChange={(e) => {
                      setConfirmPassword(e.target.value);
                    }}
                    type="password"
                    id="s-cpass"
                    className="form-control"
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="" className="label-control">
                    Gender
                  </label>
                  <select
                    className="form-select"
                    onChange={(e) => {
                      setGender(e.target.value);
                    }}
                  >
                    <option class="text-dark" value=""></option>
                    <option class="text-dark" value="Male">
                      Male
                    </option>
                    <option class="text-dark" value="Female">
                      Female
                    </option>
                  </select>
                </div>
              </div>
              <div className="col class-style">
                <div className="mb-3">
                  <label htmlFor="s-phno" className="label-control">
                    Phone No.
                  </label>
                  <input
                    onChange={(e) => {
                      setPhone(e.target.value);
                    }}
                    type="number"
                    id="s-phno"
                    className="form-control"
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="s-dob" className="label-control">
                    DOB
                  </label>
                  <input
                    onChange={(e) => {
                      setQualification(e.target.value);
                    }}
                    type="date"
                    id="s-dob"
                    className="form-control"
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="s-address" className="label-control">
                    experience
                  </label>
                  <input
                    onChange={(e) => {
                      setExperience(e.target.value);
                    }}
                    type="text"
                    id="s-address"
                    className="form-control"
                  />
                </div>

                <div className="mb-3 signup-btn">
                  <button onClick={signupLecturer} className="btn btn-primary">
                    Signup
                  </button>
                </div>
              </div>
            </div>
          </form>
          <div class="float-container">
            <div class="float-child">Already have an account?</div>
            <div class="float-child">
              <Link to="/login">Login here.</Link>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  )
}

export default LecturerSignup
