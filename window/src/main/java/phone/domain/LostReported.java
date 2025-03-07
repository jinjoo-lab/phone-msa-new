package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostReported extends AbstractEvent {

    private Long id;
    private Long userId;
    private String phoneNumber;
    private Date date;
    private String serviceType;
    private String status;

    public LostReported(Window aggregate) {
        super(aggregate);
    }

    public LostReported() {
        super();
    }
}
//>>> DDD / Domain Event
