package selfdrivingprojectmanagementservice.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import selfdrivingprojectmanagementservice.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "codingGuides",
    path = "codingGuides"
)
public interface CodingGuideRepository
    extends PagingAndSortingRepository<CodingGuide, String> {}
