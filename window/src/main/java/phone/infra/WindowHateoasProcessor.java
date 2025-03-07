package phone.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phone.domain.*;

@Component
public class WindowHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Window>> {

    @Override
    public EntityModel<Window> process(EntityModel<Window> model) {
        return model;
    }
}
