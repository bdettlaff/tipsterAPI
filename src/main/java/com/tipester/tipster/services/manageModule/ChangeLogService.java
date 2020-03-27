package com.tipester.tipster.services.manageModule;

import com.tipester.tipster.dtos.AddChangeLog;
import com.tipester.tipster.dtos.ChangeLogWithDate;
import com.tipester.tipster.entities.manageModule.ChangeLog;
import com.tipester.tipster.repositories.manageModule.ChangeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChangeLogService {

    private ChangeLogRepository changeLogRepository;

    @Autowired
    public ChangeLogService(ChangeLogRepository changeLogRepository){
        this.changeLogRepository = changeLogRepository;
    }

    @Transactional
    public void addChangeLog(AddChangeLog addChangeLog){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ChangeLog changeLog = ChangeLog.builder()
                .title(addChangeLog.getTitle())
                .content(addChangeLog.getContent())
                .date(dateFormat.format(new Date()))
                .build();

        changeLogRepository.save(changeLog);
    }

    public List<ChangeLogWithDate> getAllChangeLogs(){
        List<ChangeLog> changeLogList = changeLogRepository.findAll();
        List<ChangeLogWithDate> changeLogWithDates = new ArrayList<>();

        for(ChangeLog changeLog : changeLogList){
            ChangeLogWithDate changeLogWithDate = ChangeLogWithDate.builder()
                    .content(changeLog.getContent())
                    .title(changeLog.getTitle())
                    .date(changeLog.getDate())
                    .build();

            changeLogWithDates.add(changeLogWithDate);
        }

        return changeLogWithDates;
    }

    public List<ChangeLogWithDate> getLastThreeChangeLogs(){
        List<ChangeLog> changeLogList = changeLogRepository.findAll();
        List<ChangeLogWithDate> changeLogWithDates = new ArrayList<>();
        List<ChangeLogWithDate> resultList;

        for(ChangeLog changeLog : changeLogList){
            ChangeLogWithDate changeLogWithDate = ChangeLogWithDate.builder()
                    .content(changeLog.getContent())
                    .title(changeLog.getTitle())
                    .date(changeLog.getDate())
                    .build();

            changeLogWithDates.add(changeLogWithDate);
        }

        resultList = changeLogWithDates.stream().sorted(Comparator.comparing(ChangeLogWithDate::getDate)).collect(Collectors.toList());

        int size = resultList.size();
        changeLogWithDates = new ArrayList<>();

        changeLogWithDates.add(0,resultList.get(size-1));
        changeLogWithDates.add(1,resultList.get(size-2));
        changeLogWithDates.add(2,resultList.get(size-3));

        return changeLogWithDates;
    }

    public void deleteChangeLog(Long changeLogId){
        changeLogRepository.deleteById(changeLogId);
    }

}
