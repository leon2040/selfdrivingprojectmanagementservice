package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateCodingGuideCommand {

    private String guideId;
    private String guideName;
    private String guideContent;
}
