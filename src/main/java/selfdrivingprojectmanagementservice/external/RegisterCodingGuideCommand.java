package selfdrivingprojectmanagementservice.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class RegisterCodingGuideCommand {

    @Id
    private String guideId;

    private String guideName;
    private String guideContent;
}
