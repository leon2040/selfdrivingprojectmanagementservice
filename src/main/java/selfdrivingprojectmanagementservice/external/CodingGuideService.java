package selfdrivingprojectmanagementservice.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "coding-guide", url = "${api.url.coding-guide}")
public interface CodingGuideService {
    @RequestMapping(method = RequestMethod.POST, path = "/codingGuides")
    public void registerCodingGuide(@RequestBody CodingGuide codingGuide);

    @RequestMapping(method = RequestMethod.POST, path = "/codingGuides")
    public void registerCodingGuide(@RequestBody CodingGuide codingGuide);

    @RequestMapping(method = RequestMethod.PUT, path = "/codingGuides/{id}")
    public void updateCodingGuide(
        @PathVariable("id") String guideId,
        @RequestBody UpdateCodingGuideCommand updateCodingGuideCommand
    );

    @RequestMapping(method = RequestMethod.PUT, path = "/codingGuides/{id}")
    public void updateCodingGuide(
        @PathVariable("id") String guideId,
        @RequestBody UpdateCodingGuideCommand updateCodingGuideCommand
    );

    @RequestMapping(method = RequestMethod.DELETE, path = "/codingGuides")
    public void deleteCodingGuide(@RequestBody CodingGuide codingGuide);

    @RequestMapping(method = RequestMethod.DELETE, path = "/codingGuides")
    public void deleteCodingGuide(@RequestBody CodingGuide codingGuide);

    @RequestMapping(method = RequestMethod.POST, path = "/codingGuides")
    public void provideCodingGuide(@RequestBody CodingGuide codingGuide);

    @RequestMapping(method = RequestMethod.POST, path = "/codingGuides")
    public void provideCodingGuide(@RequestBody CodingGuide codingGuide);
}
