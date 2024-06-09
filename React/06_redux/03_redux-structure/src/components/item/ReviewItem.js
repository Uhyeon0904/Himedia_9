function ReviewItem({review}) {
    return (
        <div>
            <h1>작성자: {review.writer}</h1>
            <h1>제목: {review.title}</h1>
            <h1>내용: {review.content}</h1>
        </div>
    )
}
export default ReviewItem;