package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RunningInformationAnalysisService {

    List<RunningInformation> saveRunningInformation (List<RunningInformation> runningInformation);

    @Transactional
    void deleteByRunningId(String runningId);

    Page<RunningInformation> findAll (Pageable pageable);



}
