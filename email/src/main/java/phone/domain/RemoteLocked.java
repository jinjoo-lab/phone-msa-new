package phone.domain;

import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

@Data
@ToString
public class RemoteLocked extends AbstractEvent {

    private Long id;
    private Long windowId;
    private Long userId;
    private String phoneNumber;
    private String serviceType;
    private Boolean isDone;
    private Date doneTime;
}
