package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostCanceled extends AbstractEvent {

    private Long id;
    private Long userId;
    private String phoneNumber;
    private Date date;
    private String serviceType;
    private String status;

    public LostCanceled(Window aggregate) {
        super(aggregate);
    }

    public LostCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
