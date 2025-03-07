package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LocationSearched extends AbstractEvent {

    private Long id;
    private Long windowId;
    private Long userId;
    private String phoneNumber;
    private String serviceType;
    private Boolean isDone;
    private Date doneTime;

    public LocationSearched(Work aggregate) {
        super(aggregate);
    }

    public LocationSearched() {
        super();
    }
}
//>>> DDD / Domain Event
