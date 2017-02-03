import java.io.Serializable;

/**
 * Created by vig on 12/16/16.
 */
public class Staff implements Serializable{
    private String firstName;
    private String lastName;
    private String nickName;
    private double sallaryValue;
    private boolean isRegular;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getSallaryValue() {
        return sallaryValue;
    }

    public void setSallaryValue(double sallaryValue) {
        this.sallaryValue = sallaryValue;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
