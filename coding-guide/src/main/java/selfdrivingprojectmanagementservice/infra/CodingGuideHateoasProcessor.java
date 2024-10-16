package selfdrivingprojectmanagementservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import selfdrivingprojectmanagementservice.domain.*;

@Component
public class CodingGuideHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CodingGuide>> {

    @Override
    public EntityModel<CodingGuide> process(EntityModel<CodingGuide> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
