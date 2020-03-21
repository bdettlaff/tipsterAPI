package com.tipester.tipster.endpoints.manageModule;

import com.tipester.tipster.dtos.AddChangeLog;
import com.tipester.tipster.dtos.ChangeLogWithDate;
import com.tipester.tipster.entities.manageModule.ChangeLog;
import com.tipester.tipster.services.manageModule.ChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ChangeLogEndpoint {

    private ChangeLogService changeLogService;

    @Autowired
    public ChangeLogEndpoint(ChangeLogService changeLogService){
        this.changeLogService = changeLogService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/changelog/add")
    public ResponseEntity<ChangeLog> addChangeLog(@RequestBody AddChangeLog addChangeLog){
        changeLogService.addChangeLog(addChangeLog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/changelog/get/list")
    public ResponseEntity<List<ChangeLogWithDate>> getAllChangeLogs() {
        return new ResponseEntity<>(changeLogService.getAllChangeLogs(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/changelog/delete/{changeLogId}")
    public ResponseEntity<Void> deleteChangeLogs(@PathVariable Long changeLogId) {
        changeLogService.deleteChangeLog(changeLogId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
