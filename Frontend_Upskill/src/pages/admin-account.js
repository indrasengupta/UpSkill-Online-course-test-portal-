import { useState , useEffect} from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useLocation, useNavigate } from "react-router";
//import "./index.css"
import { URL } from '../Configurations'
import { Link } from 'react-router-dom'
import "../styles/component/profile.css"

const UpdateAdmin = () => {
  const { id } = sessionStorage

  const {state} = useLocation()
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  
  const navigate = useNavigate()
  
  // useEffect(() => {
  //   const { lecturer } = state
  //   setFirstName(lecturer.firstName)
  //   setLastName(lecturer.lastName)
  //   setEmail(lecturer.email)
  //   setPassword(lecturer.password)
  //   setGender(lecturer.gender)
  //   setPhone(lecturer.phone)
  //   setQualification(lecturer.qualification)
  //   setExperience(lecturer.experience)
  // }, [])

  useEffect(()=>{
    populate();
  },[])

  const populate = () =>{
    //const url = `${URL}/admin/update/${id}`;
    const url = `${URL}/admin/profile/3`;
      axios.get(url).then((response) => {
        const result = response.data;
        console.log(result['data']);
        setFirstName(result['data'].firstName);
        setLastName(result['data'].lastName);
        setEmail(result['data'].email);
      });
  };
  

  const updateAdmin = () => {    
    if (firstName.length == 0) {
      toast.warning("Please enter firstName");
    } else if (lastName.length == 0) {
      toast.warning("Please enter lastName");
    } else if (email.length == 0) {
      toast.warning("Please enter email");
    } else if (password.length == 0) {
      toast.warning("Please enter your password");
    } else {
      const body = {
        firstName,
        lastName,
        email,     
        password,
      };
    
      // const url = `${URL}/lecturer/update/${state.lecturer.id}`;
      //for testing purpose
      //const url = `${URL}/admin/update/${id}`;
      const url = `${URL}/admin/update/3`;
      axios.put(url, body).then((response) => {
        const result = response.data;
        //console.log(result);
        if (result["status"] == "success") {
          toast.success("Successfully updated lecturer details");
        } else {
          toast.error(result["error"]);
        }
      });
    }
  };

  const logoutAdmin = () => {
    // remove the logged users details from session storage
    sessionStorage.removeItem('id')
    // navigate to sign in component
    navigate('/login')
  }

  return (
    <div className="bg">
      <h1 className="title">My Account</h1>
      <hr></hr>
      <div className="col">
          <div className="float-end">
            <div className="btn-group " role="group">
              <button
                id="btnGroupDrop1"
                type="button"
                className="btn btn-primary dropdown-toggle"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Admin
              </button>
              <ul className="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li>
                <Link to="/home" className="dropdown-item">Home</Link>
                </li>
                <li>
                <Link to="/myAccount" className="dropdown-item">My Account</Link>
                </li>
                <li>
                  <button onClick={logoutAdmin} className="dropdown-item">
                    Logout
                  </button>
                </li>
              </ul>
            </div>
          </div>
        </div>
      

        <button  className="btn btn-success">
            Profile
          </button>
          {" "}
          
          <button  className="btn btn-success"
             onClick={() => {
                navigate('/removelecturer')
              }}
              className="btn btn-success float-end"
            >
            Remove Lecturer
          </button>
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
                value={password}
                className="form-control"
              />
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div> 
      <div className="mb-3">
          <button onClick={updateAdmin}  className="btn-primary center-btn">
            Update
          </button>
        
        </div>
        <div className="row" style={{ marginTop: '10px', marginBottom: '20px' }}>
          <div className="col"></div>
        </div>
    </div>
  )
}


export default UpdateAdmin;