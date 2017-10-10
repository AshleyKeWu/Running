package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
@Entity
@Table(name = "USER")

public class UserInfo implements  Serializable{
    @Id
    @GeneratedValue
    public long userId;

    public String userName;
    public String address;

    public UserInfo(){
    }

    public UserInfo(long userId, String address, String userName){
        this.userId = userId;
        this.userName = userName;
        this.address = address;
    }
}
