public class User {
    public String firstName;
    public String lastName;
    public String dob;
    public String ssn;
    public String address;
    public String email;
    public String tel;

    public User() {
        this.firstName = null;
        this.lastName = null;
        this.dob = null;
        this.ssn = null;
        this.address = null;
        this.email = null;
        this.tel = null;
    }

    public User(String newFirstName, String newLastname, String newDob, String newSsn, String newAddress, String newEmail, String newTel) {
        this.firstName = newFirstName;
        this.lastName = newLastname;
        this.dob = newDob;
        this.ssn = newSsn;
        this.address = newAddress;
        this.email = newEmail;
        this.tel = newTel;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String newDob) {
        this.dob = newDob;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String newSsn) {
        this.ssn = newSsn;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String newTel) {
        this.tel = newTel;
    }
}
