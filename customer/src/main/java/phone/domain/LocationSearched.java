package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phone.infra.AbstractEvent;

@Data
public class LocationSearched extends AbstractEvent {

    private Long id;
    private Long windowId;
    private Long userId;
    private String phoneNumber;
    private String serviceType;
    private Boolean isDone;
    private Date doneTime;
}
