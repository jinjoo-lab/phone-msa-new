package phone.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phone.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "windows", path = "windows")
public interface WindowRepository
    extends PagingAndSortingRepository<Window, Long> {}
