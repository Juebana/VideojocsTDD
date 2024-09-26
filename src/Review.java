public class Review {
    private User user;
    private String comment;
    private int rating;

    public Review(User user, String comment, int rating) {
        this.user = user;
        this.comment = comment;
        setRating(rating);
    }

    public User getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
    }

    @Override
    public String toString() {
        return "Review by " + user.getNickname() + ": " + rating + " stars - " + comment;
    }
}