package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DataDeleteRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private String phoneNumber;
    private Date date;
    private String serviceType;
    private String status;

    public DataDeleteRequested(Window aggregate) {
        super(aggregate);
    }

    public DataDeleteRequested() {
        super();
    }
}
//>>> DDD / Domain Event
