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
// @RequestMapping(value="/projects")
@Transactional
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(
        value = "/projects/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Project updateProject(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateProjectCommand updateProjectCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /project/updateProject  called #####");
        Optional<Project> optionalProject = projectRepository.findById(id);

        optionalProject.orElseThrow(() -> new Exception("No Entity Found"));
        Project project = optionalProject.get();
        project.updateProject(updateProjectCommand);

        projectRepository.save(project);
        return project;
    }

    @RequestMapping(
        value = "/projects/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Project assignTeamMember(
        @PathVariable(value = "id") String id,
        @RequestBody AssignTeamMemberCommand assignTeamMemberCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /project/assignTeamMember  called #####");
        Optional<Project> optionalProject = projectRepository.findById(id);

        optionalProject.orElseThrow(() -> new Exception("No Entity Found"));
        Project project = optionalProject.get();
        project.assignTeamMember(assignTeamMemberCommand);

        projectRepository.save(project);
        return project;
    }

    @RequestMapping(
        value = "/projects/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Project assignTask(
        @PathVariable(value = "id") String id,
        @RequestBody AssignTaskCommand assignTaskCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /project/assignTask  called #####");
        Optional<Project> optionalProject = projectRepository.findById(id);

        optionalProject.orElseThrow(() -> new Exception("No Entity Found"));
        Project project = optionalProject.get();
        project.assignTask(assignTaskCommand);

        projectRepository.save(project);
        return project;
    }
}
//>>> Clean Arch / Inbound Adaptor
