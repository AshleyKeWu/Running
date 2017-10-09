package demo.rest;

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

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformation){
        this.runningInformationAnalysisService.saveRunningInformation(runningInformation);
    }

    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void del_by_id(@PathVariable String runningId){
        this.runningInformationAnalysisService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<RunningInformation> findAll(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        Sort sort = new Sort(Sort.Direction.DESC, "heartRate");
        return this.runningInformationAnalysisService.findAll(new PageRequest(page,size, sort));
    }
}
