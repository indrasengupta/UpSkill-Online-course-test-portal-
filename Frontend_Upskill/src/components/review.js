// import "../styles/component/review-container.css"

const Review = (props) =>{
    const {eachreview} = props;
    //console.log("inside review component");
    //console.log(eachreview);
    return(
        <div>
            <div className="review-container">{eachreview.review}</div>
        </div>
    )
}
export default Review;