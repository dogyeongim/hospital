package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Discharged extends AbstractEvent {

    private Long id;
    private Long bedsId;
    private Long patientId;
    private Double price;
}
