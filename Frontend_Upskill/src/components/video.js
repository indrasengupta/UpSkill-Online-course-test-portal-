import { useState, useEffect } from "react";
import "../styles/component/review-container.css"

const Video = (props) =>{
    //const{video} = props.video;
    const{video} = props;
    //const [vUrl, setVUrl] = useState('');

    //console.log(video);

    // useEffect(() => {
    //     console.log("Inside useeffect of video component")
    //   }, [vUrl]);

    function populateAndSendVideoUrl(){
        // setVUrl(video.video);
        // console.log(vUrl)
        props.onLoadVideoUrl(video.video, video.vName);
    }

    return(
        <div className="review-container">
            <button className="btn btn-outline-info w-100" style={{ color: "black" }} onClick={populateAndSendVideoUrl}>
            {/* <button className="btn btn-outline-info w-100" style={{ color: "black" }}> */}
                {video.vName}
                {/* {video.video} */}
            </button>
            {/* {video.vName}
            {video.video} */}
        </div>
    )
}
export default Video;