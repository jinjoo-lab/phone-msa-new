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

        /** Example 1:  new item 
        Work work = new Work();
        repository().save(work);

        RemoteLocked remoteLocked = new RemoteLocked(work);
        remoteLocked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lockRequested.get???()).ifPresent(work->{
            
            work // do something
            repository().save(work);

            RemoteLocked remoteLocked = new RemoteLocked(work);
            remoteLocked.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void locationSearch(LostReported lostReported) {
        //implement business logic here:

        /** Example 1:  new item 
        Work work = new Work();
        repository().save(work);

        LocationSearched locationSearched = new LocationSearched(work);
        locationSearched.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostReported.get???()).ifPresent(work->{
            
            work // do something
            repository().save(work);

            LocationSearched locationSearched = new LocationSearched(work);
            locationSearched.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void dataDelete(DataDeleteRequested dataDeleteRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        Work work = new Work();
        repository().save(work);

        DataDeleted dataDeleted = new DataDeleted(work);
        dataDeleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(dataDeleteRequested.get???()).ifPresent(work->{
            
            work // do something
            repository().save(work);

            DataDeleted dataDeleted = new DataDeleted(work);
            dataDeleted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
