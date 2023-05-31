package MachineCodingPractice.SplitwiseApplication.Model;

public class User {
    private String userId;
    private String userName;
    private String userEmail;
    private String userMobile;


    public User(String userId, String userName, String userEmail, String userMobile) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
    }

    public User(String userId) {
        this.userId = userId;
    }


    public String getUserId() {
        return userId;
    }

}
