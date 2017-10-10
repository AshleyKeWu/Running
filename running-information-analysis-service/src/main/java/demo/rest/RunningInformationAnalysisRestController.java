package demo.rest;

import demo.domain.RunningInfoDTO;
import demo.domain.RunningInformation;
import demo.service.RunningInformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationAnalysisRestController {

    @Autowired
    private RunningInformationAnalysisService runningInformationAnalysisService;

    //Upload data
    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformation){
        this.runningInformationAnalysisService.saveRunningInformation(runningInformation);
    }

    //Delete by RunningId
    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void del_by_id(@PathVariable String runningId){
        this.runningInformationAnalysisService.deleteByRunningId(runningId);
    }

    //Get data, sorted by heartRate
    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<RunningInfoDTO> getAll(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        Sort sort = new Sort(Sort.Direction.DESC, "heartRate");
        return this.runningInformationAnalysisService.getAll(new PageRequest(page,size, sort));
    }


}
