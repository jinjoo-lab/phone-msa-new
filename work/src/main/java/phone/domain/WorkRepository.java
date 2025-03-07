package phone.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phone.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "works", path = "works")
public interface WorkRepository
    extends PagingAndSortingRepository<Work, Long> {}
