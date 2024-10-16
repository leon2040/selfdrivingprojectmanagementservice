package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import selfdrivingprojectmanagementservice.CodingGuideApplication;
import selfdrivingprojectmanagementservice.domain.CodingGuideDeleted;
import selfdrivingprojectmanagementservice.domain.CodingGuideProvided;
import selfdrivingprojectmanagementservice.domain.CodingGuideRegistered;

@Entity
@Table(name = "CodingGuide_table")
@Data
//<<< DDD / Aggregate Root
public class CodingGuide {

    @Id
    private String guideId;

    private String guideName;

    private String guideContent;

    @PostPersist
    public void onPostPersist() {
        CodingGuideRegistered codingGuideRegistered = new CodingGuideRegistered(
            this
        );
        codingGuideRegistered.publishAfterCommit();

        CodingGuideDeleted codingGuideDeleted = new CodingGuideDeleted(this);
        codingGuideDeleted.publishAfterCommit();

        CodingGuideProvided codingGuideProvided = new CodingGuideProvided(this);
        codingGuideProvided.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static CodingGuideRepository repository() {
        CodingGuideRepository codingGuideRepository = CodingGuideApplication.applicationContext.getBean(
            CodingGuideRepository.class
        );
        return codingGuideRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateCodingGuide(
        UpdateCodingGuideCommand updateCodingGuideCommand
    ) {
        //implement business logic here:

        CodingGuideUpdated codingGuideUpdated = new CodingGuideUpdated(this);
        codingGuideUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
