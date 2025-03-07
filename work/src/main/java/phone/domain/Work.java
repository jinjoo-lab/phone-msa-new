package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.WorkApplication;
import phone.domain.DataDeleted;
import phone.domain.LocationSearched;
import phone.domain.RemoteLocked;

@Entity
@Table(name = "Work_table")
@Data
//<<< DDD / Aggregate Root
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long windowId;

    private Long userId;

    private String phoneNumber;

    private String serviceType;

    private Boolean isDone;

    private Date doneTime;

    public static WorkRepository repository() {
        WorkRepository workRepository = WorkApplication.applicationContext.getBean(
            WorkRepository.class
        );
        return workRepository;
    }

    //<<< Clean Arch / Port Method
    public static void remoteLock(LockRequested lockRequested) {
        //implement business logic here:
        System.out.println("Lock Requested");
        Work work = new Work();
        work.userId = lockRequested.getUserId();
        work.windowId = lockRequested.getId();
        work.phoneNumber = lockRequested.getPhoneNumber();
        work.serviceType = lockRequested.getServiceType();
        work.isDone = true;
        work.doneTime = lockRequested.getDate();

        Work consistentWork = repository().save(work);

        RemoteLocked remoteLocked = new RemoteLocked(consistentWork);
        remoteLocked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void locationSearch(LostReported lostReported) {
        //implement business logic here:
        System.out.println("Location Searched");
        Work work = new Work();
        work.userId = lostReported.getUserId();
        work.windowId = lostReported.getId();
        work.phoneNumber = lostReported.getPhoneNumber();
        work.serviceType = lostReported.getServiceType();
        work.isDone = true;
        work.doneTime = lostReported.getDate();

        Work consistentWork = repository().save(work);

        LocationSearched locationSearched = new LocationSearched(consistentWork);
        locationSearched.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void dataDelete(DataDeleteRequested dataDeleteRequested) {
        //implement business logic here:
        System.out.println("Data delete requested");
        Work work = new Work();
        work.userId = dataDeleteRequested.getUserId();
        work.windowId = dataDeleteRequested.getId();
        work.phoneNumber = dataDeleteRequested.getPhoneNumber();
        work.serviceType = dataDeleteRequested.getServiceType();
        work.isDone = true;
        work.doneTime = dataDeleteRequested.getDate();

        Work consistentWork = repository().save(work);

        DataDeleted dataDeleted = new DataDeleted(consistentWork);
        dataDeleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
