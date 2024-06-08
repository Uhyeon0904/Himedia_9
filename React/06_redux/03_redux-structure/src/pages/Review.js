import { useDispatch } from "react-redux";
import ReviewList from "../components/list/ReviewList";

function Review() {
    const dispatch = useDispatch();

    return (
        <div>
            <h1>리뷰 목록</h1>
            <ReviewList/>
        </div>
    )
}
export default Review;