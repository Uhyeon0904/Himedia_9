import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { callgetReview } from "../../api/MenuAPICalls";
import ReviewItem from "../item/ReviewItem";

function ReviewList() {

    const dispatch = useDispatch();

    useEffect( () => {
        dispatch(callgetReview());
    }, [])

    const { reviewList } = useSelector(state => state.menuReducer)

    return (
        <div>
            {reviewList && reviewList.map(review => <ReviewItem key={review.id} review={review}/>)}
        </div>
    )
}
export default ReviewList;