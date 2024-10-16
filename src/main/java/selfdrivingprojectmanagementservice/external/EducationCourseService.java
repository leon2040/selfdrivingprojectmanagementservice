package selfdrivingprojectmanagementservice.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "education-support", url = "${api.url.education-support}")
public interface EducationCourseService {
    @RequestMapping(method = RequestMethod.POST, path = "/educationCourses")
    public void scheduleTraining(@RequestBody EducationCourse educationCourse);

    @RequestMapping(method = RequestMethod.POST, path = "/educationCourses")
    public void scheduleTraining(@RequestBody EducationCourse educationCourse);

    @RequestMapping(method = RequestMethod.POST, path = "/educationCourses")
    public void provideTrainingMaterial(
        @RequestBody EducationCourse educationCourse
    );

    @RequestMapping(method = RequestMethod.POST, path = "/educationCourses")
    public void provideTrainingMaterial(
        @RequestBody EducationCourse educationCourse
    );

    @RequestMapping(method = RequestMethod.POST, path = "/educationCourses")
    public void provideCodeExamples(
        @RequestBody EducationCourse educationCourse
    );

    @RequestMapping(method = RequestMethod.POST, path = "/educationCourses")
    public void provideCodeExamples(
        @RequestBody EducationCourse educationCourse
    );

    @RequestMapping(method = RequestMethod.POST, path = "/educationCourses")
    public void provideTrainingFeedback(
        @RequestBody EducationCourse educationCourse
    );

    @RequestMapping(method = RequestMethod.POST, path = "/educationCourses")
    public void provideTrainingFeedback(
        @RequestBody EducationCourse educationCourse
    );
}
