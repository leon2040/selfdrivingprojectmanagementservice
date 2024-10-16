package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AssignTeamMemberCommand {

    private String projectId;
    private String teamMemberId;
}
