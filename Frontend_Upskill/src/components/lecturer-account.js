
import { useState , useEffect} from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useLocation, useNavigate } from "react-router";
// import "./index.css"
import { Link } from 'react-router-dom'
import { URL } from "../Configurations";
import "../styles/component/profile.css"
import "../styles/component/lecturer-account.css"


    const UpdateLecturer = () => {
      const session = JSON.parse(sessionStorage.getItem('session'));
      const lecturerId = session.lecturerId;
       
      console.log("##########")
      console.log(lecturerId)


  const [lecturer, setLecturer] = useState('')
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [gender, setGender] = useState("");
  const [phone, setPhone] = useState("");
  const [qualification, setQualification] = useState("");
  const [experience, setExperience] = useState("");
 
          
    
    
        const navigate = useNavigate()
        
        useEffect(() => {
          loadLecturerProfile()
         
        }, [])
        const loadLecturerProfile = () => {
          // const url = `${URL}/lecturer/profile/2`;
          const url = `${URL}/lecturer/profile/${lecturerId}`
           axios.get(url).then((response) => {
             const result = response.data
             if (result['status'] == 'success') {
              // setLecturer(result['data'])
              setFirstName(result['data'].firstName);
              setLastName(result['data'].lastName);
              setEmail(result['data'].email);
              setPassword(result['data'].password);
              setGender(result['data'].gender);
              setPhone(result['data'].phone);
              setQualification(result['data'].qualification);
              setExperience(result['data'].experience);
               console.log(result.data)
              
             }
             console.log(result.data.error)
           })
         }

        const updateLecturer = () => {

    
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
          } else if (phone.length == 0) {
            toast.warning("Please enter phone");
          } else if (qualification.length == 0) {
            toast.warning("Please enter qualification");
          } else if (experience.length == 0) {
            toast.warning("Please enter your experience");
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
              
              
            };

           
            // const url = `${URL}/lecturer/update/${lecturerId}`;
   //for testing purpose
            const url = `${URL}/lecturer/update/2`;
      axios.put(url, body).then((response) => {
        
        const result = response.data;
        console.log(result);
        if (result["status"] == "success") {
          toast.success("Successfully updated lecturer details");
          window.location.reload(true);
          
        
        } else {
          toast.error(result["error"]);
        }
        
      });
   
    }  
        
  };
  const logoutLecturer = () => {
    // remove the logged users details from session storage
    sessionStorage.removeItem('id')
   
  

    // navigate to sign in component
    navigate('/login')
  }

  

return (
    <div>
      <div className="col">
          <div className="float-end">
            <div className="btn-group " role="group">
            </div>
          </div>
        </div>
      

        
<h3 className="lecturer-title">Lecturer Profile</h3>
          <div className="col"></div>
          <div className="col"></div>
          

      <div className="row">
        <div className="col"></div>
        
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
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
              { <label htmlFor="" className="label-control">
                Last Name:-
              </label> }
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
              <label  htmlFor="" className="label-control">
             
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
              <label  htmlFor="" className="label-control">
             
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
              <label  htmlFor="" className="label-control">
             
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
              <label  htmlFor="" className="label-control">
             
                Qualification:-
              </label>
              <input
                onChange={(e) => {
                  setQualification(e.target.value)
                }}
                type="text"
                value={qualification}
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label  htmlFor="" className="label-control">
             
                Experience:-
              </label>
              <input
                onChange={(e) => {
                  setExperience(e.target.value)
                }}
                type="text"
                value={experience}
                className="form-control"
              />
            </div>
          
          </div>
        </div>
        <div className="col"></div>
      </div> 
      <div className="mb-3">
          <button onClick={updateLecturer}    className="btn-primary center-btn">
          
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


export default UpdateLecturer