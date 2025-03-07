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

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void serviceMailSend(LocationSearched locationSearched) {
        System.out.println("serviceMailSend : LOCATION SEARCHED");

        Email email = new Email();
        email.userId = locationSearched.getUserId();
        email.phoneNumber = locationSearched.getPhoneNumber();
        email.title = "[Location Searched]";
        email.content = "We find your Phone Location !";
        email.date = locationSearched.getDoneTime();

        Email consistentEmail = repository().save(email);

        ServiceMailSent serviceMailSent = new ServiceMailSent(consistentEmail);
        serviceMailSent.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void serviceMailSend(RemoteLocked remoteLocked) {
        //implement business logic here:
        System.out.println("serviceMailSend : REMOTE LOCKED");

        Email email = new Email();
        email.userId = remoteLocked.getUserId();
        email.phoneNumber = remoteLocked.getPhoneNumber();
        email.title = "[REMOTE LOCKED]";
        email.content = "Your Phone Remote Locked !";
        email.date = remoteLocked.getDoneTime();

        Email consistentEmail = repository().save(email);

        ServiceMailSent serviceMailSent = new ServiceMailSent(consistentEmail);
        serviceMailSent.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void serviceMailSend(DataDeleted dataDeleted) {
        //implement business logic here:
        System.out.println("serviceMailSend : DATA DELETED");

        Email email = new Email();
        email.userId = dataDeleted.getUserId();
        email.phoneNumber = dataDeleted.getPhoneNumber();
        email.title = "[DATA DELETED]";
        email.content = "Your Data Deleted !";
        email.date = dataDeleted.getDoneTime();

        Email consistentEmail = repository().save(email);

        ServiceMailSent serviceMailSent = new ServiceMailSent(consistentEmail);
        serviceMailSent.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
