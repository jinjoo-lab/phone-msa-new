package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.WindowApplication;
import phone.domain.DataDeleteRequested;
import phone.domain.LockRequested;
import phone.domain.LostCanceled;
import phone.domain.LostReported;

@Entity
@Table(name = "Window_table")
@Data
//<<< DDD / Aggregate Root
public class Window {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String phoneNumber;

    private Date date;

    private String serviceType;

    private String status;

    @PostPersist
    public void onPostPersist() {
        LostReported lostReported = new LostReported(this);
        lostReported.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        if(this.serviceType.equals("DATA_DELETE")) {
            DataDeleteRequested dataDeleteRequested = new DataDeleteRequested(this);
            dataDeleteRequested.publishAfterCommit();
        }

        if(this.serviceType.equals("LOCK_REQUEST")) {
            LockRequested lockRequested = new LockRequested(this);
            lockRequested.publishAfterCommit();
        }
    }

    @PostRemove
    public void onPostRemove() {
        LostCanceled lostCanceled = new LostCanceled(this);
        lostCanceled.publishAfterCommit();
    }

    public static WindowRepository repository() {
        WindowRepository windowRepository = WindowApplication.applicationContext.getBean(
            WindowRepository.class
        );
        return windowRepository;
    }
}
//>>> DDD / Aggregate Root
