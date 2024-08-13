package electricity;

public class User {
    private static int idCounter = 0;
    private int userId;
    private String name;
    private String password;
    private String phoneNumber;
    private String email;
    private String electricityBoardNo;

    public User(String name, String password, String phoneNumber, String email, String electricityBoardNo) {
        this.userId = ++idCounter; // Automatically assign a unique ID
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.electricityBoardNo = electricityBoardNo;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getElectricityBoardNo() {
        return electricityBoardNo;
    }

    public void setElectricityBoardNo(String electricityBoardNo) {
        this.electricityBoardNo = electricityBoardNo;
    }
}
