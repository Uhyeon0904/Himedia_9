import { useEffect } from "react";
import { useDispatch } from "react-redux";
import { callgetReview } from "../../api/MenuAPICalls";

function ReviewList() {

    const dispatch = useDispatch();

    useEffect( () => {
        dispatch(callgetReview());
    }, [])

    return (
        <div>
            <h2>review's</h2>
        </div>
    )
}
export default ReviewList;