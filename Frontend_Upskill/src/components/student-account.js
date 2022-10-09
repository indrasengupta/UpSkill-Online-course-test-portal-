import axios from 'axios'
import "../styles/Pages/pageLayout.css";
import { toast } from "react-toastify";
import { useLocation, useNavigate } from 'react-router'
import { useState , useEffect} from "react";
import { URL } from "../Configurations";
import { Link } from 'react-router-dom'
import "../styles/component/profile.css"
    const UpdateStudent = () => {
        
      const { id } = sessionStorage
      const {state} = useLocation()
      const [firstName, setFirstName] = useState("");
      const [lastName, setLastName] = useState("");
      const [email, setEmail] = useState("");
      const [password, setPassword] = useState("");
      const [gender, setGender] = useState("");
      const [dateOfBirth, setDateOfBirth] = useState("");
      const [phone, setPhone] = useState("");
      const [address, setAddress] = useState("");
      const [district, setDistrict] = useState("");
      const [pincode, setPincode] = useState("");
      const session = JSON.parse(sessionStorage.getItem('session'));
  const studentId = session.studentId;
      console.log(studentId);
    
    
        const navigate = useNavigate()

          useEffect(() => {
        loadStudentProfile()
         }, [])

         const loadStudentProfile = () => {
            const url = `${URL}/student/profile/${studentId}`
             axios.get(url).then((response) => {
               const result = response.data
               if (result['status'] == 'success') {
                setFirstName(result['data'].firstName);
                setLastName(result['data'].lastName);
                setEmail(result['data'].email);
                setPassword(result['data'].password);
                setGender(result['data'].gender);
                setDateOfBirth(result['data'].dateOfBirth);
                setPhone(result['data'].phone);
                setAddress(result['data'].address);
                setDistrict(result['data'].district);
                setPincode(result['data'].pincode);
                 console.log(result.data)
                
               }
               console.log(result.data.error)
             })
           }

        const updateStudent = () => {

    
          if (firstName.length == 0) {
            toast.warning("Please enter firstName");
          } else if (lastName.length == 0) {
            toast.warning("Please enter lastName");
          } else if (email.length == 0) {
            toast.warning("Please enter email");
          } else if (password.length == 0) {
            toast.warning("Please enter your password");
          } else if (gender.length == 0) {
            toast.warning("Please enter gender");
          } else if (dateOfBirth.length == 0) {
            toast.warning("Please enter dateOfBirth");
          } else if (phone.length == 0) {
            toast.warning("Please enter phone");
          } else if (address.length == 0) {
            toast.warning("Please enter address");
          } else if (district.length == 0) {
            toast.warning("Please enter your district");
          } else if (pincode.length == 0) {
            toast.warning("Please enter pincode");
          } else {
            const body = {
              
              firstName,
              lastName,
              email,     
              password,
              gender,
              dateOfBirth,
              phone,
              address,
              district,
              
              pincode
              
              
            };
            const url = `${URL}/student/update/${studentId}`;
            axios.put(url, body).then((response) => {
     
     const result = response.data;
     console.log(result);
     if (result["status"] == "success") {
       toast.success("Successfully updated student details");

       window.location.reload(true);
     
     } else {
       toast.error(result["error"]);
     }
   });
       }
};

const logoutStudent = () => {
  sessionStorage.removeItem('id')


  navigate('/signin')
}  
        

return (
    <div>
        <h3 className="title profile-title">Student Profile</h3>
          {" "}
          <div className="col"></div>
          <div className="col"></div>

      <div className="row" student-profile>
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="form-label">
                First Name:-
              </label>
              <input
                onChange={(e) => {
                  setFirstName(e.target.value)
                }}
                type="text"
                value={firstName}
                className="form-control"
              />
            </div>
            
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Last Name:-
              </label>
              <input
                onChange={(e) => {
                  setLastName(e.target.value)
                }}
                type="text"
                value={lastName}
                className="form-control"
              />
            </div>
            
            
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Email:-
              </label>
              <input
                onChange={(e) => {
                  setEmail(e.target.value)
                }}
                type="text"
                value={email}
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Password:-
              </label>
              <input
                onChange={(e) => {
                  setPassword(e.target.value)
                }}
                type="password"
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
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                DOB:-
              </label>
              <input
                onChange={(e) => {
                  setDateOfBirth(e.target.value)
                }}
                type="date"
                value={dateOfBirth}
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Phone:-
              </label>
              <input
                onChange={(e) => {
                  setPhone(e.target.value)
                }}
                type="text"
                value={phone}
                className="form-control"
              />
            </div>
          
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Address:-
              </label>
              <input
                onChange={(e) => {
                  setAddress(e.target.value)
                }}
                type="text"
                value={address}
                className="form-control"
              />
            </div>
            
          
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                District:-
              </label>
              <input
                onChange={(e) => {
                  setDistrict(e.target.value)
                }}
                type="text"
                value={district}
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Pincode:-
              </label>
              <input
                onChange={(e) => {
                  setPincode(e.target.value)
                }}
                type="text"
                value={pincode}
                className="form-control"
              />
            </div>
          
          </div>
        </div>
        <div className="col"></div>
      </div> 
      <div className="mb-3">
        
          <button  onClick={updateStudent}  className="btn-primary center-btn">
            Update
          </button>
        
        </div>
        <div className="row" style={{ marginTop: '10px', marginBottom: '20px' }}>
                    <div className="col">

                    </div>
                </div>
     </div>
  )
}


export default UpdateStudent