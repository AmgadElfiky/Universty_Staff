package domain;

public class user {
    String User_name,Password,Department;
    //constractor
    public user(String User_name, String Password, String Department)
    {
        this.User_name = User_name;
        this.Password = Password;
        this.Department = Department;
    }
    
    //setter and getter
    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }
    
}
