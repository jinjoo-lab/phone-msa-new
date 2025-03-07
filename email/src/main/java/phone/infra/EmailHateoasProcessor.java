package phone.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phone.domain.*;

@Component
public class EmailHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Email>> {

    @Override
    public EntityModel<Email> process(EntityModel<Email> model) {
        return model;
    }
}
