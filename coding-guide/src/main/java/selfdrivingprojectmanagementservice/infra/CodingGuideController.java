package selfdrivingprojectmanagementservice.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import selfdrivingprojectmanagementservice.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/codingGuides")
@Transactional
public class CodingGuideController {

    @Autowired
    CodingGuideRepository codingGuideRepository;

    @RequestMapping(
        value = "/codingGuides/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public CodingGuide updateCodingGuide(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateCodingGuideCommand updateCodingGuideCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /codingGuide/updateCodingGuide  called #####"
        );
        Optional<CodingGuide> optionalCodingGuide = codingGuideRepository.findById(
            id
        );

        optionalCodingGuide.orElseThrow(() -> new Exception("No Entity Found"));
        CodingGuide codingGuide = optionalCodingGuide.get();
        codingGuide.updateCodingGuide(updateCodingGuideCommand);

        codingGuideRepository.save(codingGuide);
        return codingGuide;
    }
}
//>>> Clean Arch / Inbound Adaptor
