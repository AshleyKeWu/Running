package demo.service.impl;

import demo.domain.RunningInfoDTO;
import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.service.RunningInformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RunningInformationAnalysisServiceImpl implements RunningInformationAnalysisService{

    @Autowired
    private RunningInformationRepository runningInformationRepository;

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation) {
        //generate a random heartRate and decide the healthWarningLevel accordingly
        for(RunningInformation run_info: runningInformation){
            run_info.setHeartRate((int) (60+Math.random()*141));
            if(run_info.getHeartRate()>=60 && run_info.getHeartRate() <=75)
                run_info.setWarningLevel(RunningInformation.healthWarningLevel.LOW);
            else if (run_info.getHeartRate()>=75 && run_info.getHeartRate() <=120)
                run_info.setWarningLevel(RunningInformation.healthWarningLevel.NORMAL);
            else
                run_info.setWarningLevel(RunningInformation.healthWarningLevel.HIGH);
        }
        return this.runningInformationRepository.save(runningInformation);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        this.runningInformationRepository.deleteByRunningId(runningId);
    }


    @Override
    public Page<RunningInformation> findAll(Pageable pageable) {
        return this.runningInformationRepository.findAll(pageable);
    }

    public Page<RunningInfoDTO> getAll (Pageable pageable){
        List<RunningInfoDTO> runningInfoDTOS = new ArrayList<RunningInfoDTO>();
        List<RunningInformation> runningInfo = this.runningInformationRepository.findAll(pageable).getContent();

        //convert to DTO object
        for (RunningInformation runInfo: runningInfo){
            RunningInfoDTO runInfoDto = new RunningInfoDTO();
            runInfoDto.setUserId(runInfo.getUserInfo().getUserId());
            runInfoDto.setUserName(runInfo.getUserInfo().getUserName());
            runInfoDto.setUserAddress(runInfo.getUserInfo().getAddress());
            runInfoDto.setRunningId(runInfo.getRunningId());
            runInfoDto.setHealthWarningLevel(runInfo.getWarningLevel());
            runInfoDto.setHeartRate(runInfo.getHeartRate());
            runInfoDto.setTotalRunningTime(runInfo.getTotalRunningTime());
            runningInfoDTOS.add(runInfoDto);
        }
        Page<RunningInfoDTO> runningInfoDto = new PageImpl<RunningInfoDTO>(runningInfoDTOS);
        return runningInfoDto;
    }

}
