package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    @Id
    public final String runningId;

    private double latitude;

    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;

    public enum healthWarningLevel{
        LOW, NORMAL, HIGH;
    }
    private String timeStamp;

    @ManyToOne(targetEntity = UserInfo.class, cascade = CascadeType.ALL)
    private UserInfo userInfo;

    private healthWarningLevel warningLevel;

    public RunningInformation(){
        this.runningId = "";
    }

    @JsonCreator
    public RunningInformation(@JsonProperty String runningId){
        this.runningId = runningId;
    }


    public String getUserName(){
        return this.userInfo == null?null:this.userInfo.getUserName();
    }

    public String getAddress(){
        return this.userInfo == null?null:this.userInfo.getAddress();
    }

    public long getUserId(){
        return this.userInfo == null?null:this.userInfo.getUserId();
    }

}
