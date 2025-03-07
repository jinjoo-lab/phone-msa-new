package phone.domain;

import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

@Data
@ToString
public class LockRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private String phoneNumber;
    private Date date;
    private String serviceType;
    private String status;
}
