package selfdrivingprojectmanagementservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import selfdrivingprojectmanagementservice.domain.*;

@Component
public class EducationCourseHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<EducationCourse>> {

    @Override
    public EntityModel<EducationCourse> process(
        EntityModel<EducationCourse> model
    ) {
        return model;
    }
}
