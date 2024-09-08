package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.PatientApplication;
import untitled.domain.PatientDeleted;
import untitled.domain.PatientModified;
import untitled.domain.PatientRegistered;

@Entity
@Table(name = "Patient_table")
@Data
//<<< DDD / Aggregate Root
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String patientName;

    private String patientDisease;

    private String patientNumber;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PatientRegistered patientRegistered = new PatientRegistered(this);
        patientRegistered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        PatientModified patientModified = new PatientModified(this);
        patientModified.publishAfterCommit();

        PatientDeleted patientDeleted = new PatientDeleted(this);
        patientDeleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static PatientRepository repository() {
        PatientRepository patientRepository = PatientApplication.applicationContext.getBean(
            PatientRepository.class
        );
        return patientRepository;
    }

    //<<< Clean Arch / Port Method
    public void patientDelete() {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void sendMessage(
        HospitalizationApproved hospitalizationApproved
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Patient patient = new Patient();
        repository().save(patient);

        */

        /** Example 2:  finding and process
        
        repository().findById(hospitalizationApproved.get???()).ifPresent(patient->{
            
            patient // do something
            repository().save(patient);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void sendMessage(
        HospitalizationRejected hospitalizationRejected
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Patient patient = new Patient();
        repository().save(patient);

        */

        /** Example 2:  finding and process
        
        repository().findById(hospitalizationRejected.get???()).ifPresent(patient->{
            
            patient // do something
            repository().save(patient);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
