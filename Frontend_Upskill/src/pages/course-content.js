import { useState, useEffect } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { Navigate, useLocation, useNavigate } from "react-router";
import { URL } from "../Configurations";
import { Link } from "react-router-dom";
import "../styles/Pages/courseContent.css";
import ReactPlayer from "react-player";
import ReactStars from "react-rating-stars-component";
import Review from "../components/review";
import Video from "../components/video";
import Scrollbars from "react-custom-scrollbars-2";
import Dropdown from "../components/drop-down";

const CourseContent = () => {
  const [courseId, setCourseId] = useState();
  const [courseTitle, setCourseTitle] = useState();
  const [videosList, setVideosList] = useState();
  const [video1, setVideo1] = useState();
  const [video1Name, setVideo1Name] = useState();
  const [reviewList, setReviewList] = useState();
  const [avgRating, setAvgRating] = useState();
  const [rating, setRating] = useState(0.0);
  const [hover, setHover] = useState(0);
  const [review, setReview] = useState();
  const [videourl, setVideoUrl] = useState();
  const [videoName, setVideoName] = useState();

  const {studentId,} = sessionStorage;
  const {state} = useLocation();
  const id=state.courseId;

  const navigate = useNavigate();

  const populate = () => {
    const url = `${URL}/course-content/${id}`;
    axios.get(url).then((response) => {
      const result = response.data;
      console.log(result["data"]);
      setCourseId(result["data"].courseId);
      setCourseTitle(result["data"].courseTitle);
      setVideosList(result["data"].videosList);
      setVideo1(result["data"].video1);
      if(videourl==null){setVideoUrl(result["data"].video1);}
      if(videoName==null){setVideoName(result["data"].video1Name)};
      setReviewList(result["data"].reviewList);
      setAvgRating(result["data"].avgRating);
    });
  };

  useEffect(() => {
    populate();
    ratingChanged();
  }, [videourl, rating]);

  // useEffect(() => {
  //   ratingChanged();
  // }, []);

  const loadVideoUrlHandler = (vUrl, vName) => {
    setVideoUrl(vUrl);
    setVideoName(vName);
    //setVideoName(vName);
    //console.log(vUrl);
    //window.location = "/coursecontent";
  };

  const submitReview = () => {
    console.log(review);
    console.log(courseId);
    console.log(studentId);

    const body = {
      review,
      courseId,
      studentId,
    };
    const url = `${URL}/course-content/addReview`;
    axios.post(url, body).then((response) => {
      const result = response.data;
      //console.log(result);
      if (result["status"] == "success") {
        toast.success("successfully added a review");
        setReview("");
        // refreshing the course-content
        populate();
      } else {
        toast.error(result["error"]);
      }
    });
  };
  //console.log(avgRating)
  //console.log(rating);
  function ratingHandler(newRating){
    console.log(newRating);
    setRating(newRating);
    //ratingChanged();
  }

  const ratingChanged = () => {
    if(rating!=0.0){
      // console.log(newRating);
      // setRating(newRating);
      const url = `${URL}/course-content/addRating`
      const body = {
        rating,
        courseId,
        studentId,
      };
      console.log(body)
      axios.post(url, body).then((response) => {
        const result = response.data;
        //console.log(result);
        if (result["status"] == "success") {
          toast.success("successfully added a rating");
          // refreshing the course-content
          populate();
        } else {
          toast.error(result["error"]);
        }
      });
    }
  };

  return (
    <div className="layout">
      <Dropdown/>
      <div className="row">
        <div className="col-8">
          <div>
            <div className="row">
              <div className="check4">
                <div className="check8">{videoName}</div>
                <div className="player-wrapper">
                  <ReactPlayer 
                    // className="react-player"
                    width="100%"
                    height="100%"
                    url={videourl}
                    controls={true}
                    // muted
                    config={{
                    youtube: {
                    playerVars: { showinfo: 1 }
                    }
                    }}
                  />
                </div>
              </div>
            </div>
            <div className="row">
              <div className="check5">
                <div className="check9">
                  <button
                    className="btn btn-primary"
                    onClick={() => {
                      navigate("/give-test", { state: { id:id } });
                    }}
                  >
                    Give Test
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="col-4">
          <div>
            <div className="row">
              <div className="check6">
                <h6>
                  Give us Rating:
                  <ReactStars
                    name="rating"
                    onChange={ratingHandler}
                    activeColor="#FFA500"
                    edit={true}
                    value={avgRating}
                    size={30}
                    count={5}
                    isHalf={true}
                  />
                  Avg Rating : {avgRating}
                </h6>
                {/* <div className="star-rating">
                  {[...Array(5)].map((star, index) => {
                    index += 1;
                    return (
                    <button
                      type="button"
                      key={index}
                      className={index <= (hover || rating) ? "on" : "off"}
                      onClick={() => setRating(index)}
                      onMouseEnter={() => setHover(index)}
                      onMouseLeave={() => setHover(rating)}
                    >
                      <span className="star">&#9733;</span>
                    </button>
                    );
                  })}
                </div> */}
              </div>
            </div>
            <div className="row">
              
              {videosList && (
                <div className="check7">
                  
                  <div className="row" style={{position:"fixed"}}>
                  <h5>{courseTitle} Videos:</h5>  
                  </div>
                  
                  <div  className="row">
                    <div className="check10">
                      <Scrollbars>
                        {videosList.map((video) => {
                          return (
                            <Video
                              video={video}
                              onLoadVideoUrl={loadVideoUrlHandler}
                            />
                            //<Video video={video} />
                          );
                        })}
                      </Scrollbars>
                    </div>
                  </div>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
      <div className="row">
        <div className="col">
          {reviewList && (
            <div className="check3">
              {reviewList.map((eachreview) => {
                return <Review eachreview={eachreview} />;
              })}
            </div>
          )}
        </div>
        <div className="col">
          <textarea
            rows="6"
            cols="66"
            style={{ color: "red" }}
            onChange={(e) => {
              setReview(e.target.value);
            }}
          ></textarea>
          <button className="btn btn-primary" onClick={submitReview}>
            Add Review
          </button>
        </div>
      </div>
    </div>
  );
};

export default CourseContent;
