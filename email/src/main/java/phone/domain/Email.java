package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.EmailApplication;
import phone.domain.LostMailSent;
import phone.domain.ServiceMailSent;

@Entity
@Table(name = "Email_table")
@Data
//<<< DDD / Aggregate Root
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String phoneNumber;

    private String title;

    private String content;

    private Date date;

    public static EmailRepository repository() {
        EmailRepository emailRepository = EmailApplication.applicationContext.getBean(
            EmailRepository.class
        );
        return emailRepository;
    }

    //<<< Clean Arch / Port Method
    public static void lostMailSend(LostReported lostReported) {
        //implement business logic here:

        /** Example 1:  new item 
        Email email = new Email();
        repository().save(email);

        LostMailSent lostMailSent = new LostMailSent(email);
        lostMailSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostReported.get???()).ifPresent(email->{
            
            email // do something
            repository().save(email);

            LostMailSent lostMailSent = new LostMailSent(email);
            lostMailSent.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void serviceMailSend(LocationSearched locationSearched) {
        //implement business logic here:

        /** Example 1:  new item 
        Email email = new Email();
        repository().save(email);

        ServiceMailSent serviceMailSent = new ServiceMailSent(email);
        serviceMailSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(locationSearched.get???()).ifPresent(email->{
            
            email // do something
            repository().save(email);

            ServiceMailSent serviceMailSent = new ServiceMailSent(email);
            serviceMailSent.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void serviceMailSend(RemoteLocked remoteLocked) {
        //implement business logic here:

        /** Example 1:  new item 
        Email email = new Email();
        repository().save(email);

        ServiceMailSent serviceMailSent = new ServiceMailSent(email);
        serviceMailSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(remoteLocked.get???()).ifPresent(email->{
            
            email // do something
            repository().save(email);

            ServiceMailSent serviceMailSent = new ServiceMailSent(email);
            serviceMailSent.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void serviceMailSend(DataDeleted dataDeleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Email email = new Email();
        repository().save(email);

        ServiceMailSent serviceMailSent = new ServiceMailSent(email);
        serviceMailSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(dataDeleted.get???()).ifPresent(email->{
            
            email // do something
            repository().save(email);

            ServiceMailSent serviceMailSent = new ServiceMailSent(email);
            serviceMailSent.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
