package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.BedsApplication;
import untitled.domain.BedsRegistered;

@Entity
@Table(name = "Beds_table")
@Data
//<<< DDD / Aggregate Root
public class Beds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hospitalName;

    private Double lat;

    private Double lng;

    private Integer remain;

    private Integer totalBeds;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        BedsRegistered bedsRegistered = new BedsRegistered(this);
        bedsRegistered.publishAfterCommit();
    }

    public static BedsRepository repository() {
        BedsRepository bedsRepository = BedsApplication.applicationContext.getBean(
            BedsRepository.class
        );
        return bedsRepository;
    }

    //<<< Clean Arch / Port Method
    public static void bedsUpdate(
        HospitalizationApproved hospitalizationApproved
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Beds beds = new Beds();
        repository().save(beds);

        */

        /** Example 2:  finding and process
        
        repository().findById(hospitalizationApproved.get???()).ifPresent(beds->{
            
            beds // do something
            repository().save(beds);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void bedsUpdate(Discharged discharged) {
        //implement business logic here:

        /** Example 1:  new item 
        Beds beds = new Beds();
        repository().save(beds);

        */

        /** Example 2:  finding and process
        
        repository().findById(discharged.get???()).ifPresent(beds->{
            
            beds // do something
            repository().save(beds);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
