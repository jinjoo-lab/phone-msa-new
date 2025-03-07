package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostMailSent extends AbstractEvent {

    private Long id;
    private Long userId;
    private String phoneNumber;
    private String title;
    private String content;
    private Date date;

    public LostMailSent(Email aggregate) {
        super(aggregate);
    }

    public LostMailSent() {
        super();
    }
}
//>>> DDD / Domain Event
