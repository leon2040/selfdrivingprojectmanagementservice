package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ProvideCodingGuideCommand {

    private String guideId;
    private String guideContent;
}
