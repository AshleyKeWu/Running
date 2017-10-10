package demo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class RunningInfoDTO implements Serializable{

    private String runningId;
    private double totalRunningTime;
    private int heartRate;

    private long UserId;
    private String userName;
    private String userAddress;

    private RunningInformation.healthWarningLevel healthWarningLevel;

    public RunningInfoDTO(){

    }

    public RunningInfoDTO(String runningId){
        this.runningId = runningId;
    }
}
