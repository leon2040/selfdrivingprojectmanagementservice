package selfdrivingprojectmanagementservice.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class ProvideTrainingMaterialCommand {

    @Id
    private String courseId;

    private String materialId;
}
