package entity;
// Generated Sep 22, 2019 8:37:37 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer userId;
    
     private String userName;
     private String password;
     private String email;
     private Date regDate;
     private String mobileNo;
     private String gender;
     private String firstName;
     private String lastName;
     private Date dob;

    public User() {
    }

	
    public User( String password, String email, Date regDate, String mobileNo, String gender, String firstName, String lastName, Date dob) {
        
        this.password = password;
        this.email = email;
        this.regDate = regDate;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }
    public User( String userName, String password, String email, Date regDate, String mobileNo, String gender, String firstName, String lastName, Date dob) {
     
       this.userName = userName;
       this.password = password;
       this.email = email;
       this.regDate = regDate;
       this.mobileNo = mobileNo;
       this.gender = gender;
       this.firstName = firstName;
       this.lastName = lastName;
       this.dob = dob;
    }

   

   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
  
    

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getRegDate() {
        return this.regDate;
    }
    
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public String getMobileNo() {
        return this.mobileNo;
    }
    
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }




}

