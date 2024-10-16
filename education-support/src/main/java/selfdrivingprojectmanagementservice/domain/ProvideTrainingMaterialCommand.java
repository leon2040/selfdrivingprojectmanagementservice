package selfdrivingprojectmanagementservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ProvideTrainingMaterialCommand {

    private String courseId;
    private String materialId;
}
