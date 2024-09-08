package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BedsRegistered extends AbstractEvent {

    private Long id;

    public BedsRegistered(Beds aggregate) {
        super(aggregate);
    }

    public BedsRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
