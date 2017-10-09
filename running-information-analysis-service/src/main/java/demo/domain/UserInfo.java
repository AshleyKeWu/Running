package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
//@Entity
//@Table(name = "USER")

public class UserInfo {
    //@Id
    //@GeneratedValue
    //@OneToMany(targetEntity = RunningInformation.class)
    public long userId;

    public String userName;
    public String address;

    public UserInfo(){
    }

    public UserInfo(String address, String userName){
        //this.userId = userId;
        this.userName = userName;
        this.address = address;
    }
}
