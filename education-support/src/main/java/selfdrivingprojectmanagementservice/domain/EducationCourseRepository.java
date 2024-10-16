package selfdrivingprojectmanagementservice.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import selfdrivingprojectmanagementservice.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "educationCourses",
    path = "educationCourses"
)
public interface EducationCourseRepository
    extends PagingAndSortingRepository<EducationCourse, String> {}
