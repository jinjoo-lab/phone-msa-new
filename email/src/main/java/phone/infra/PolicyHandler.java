package phone.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phone.config.kafka.KafkaProcessor;
import phone.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    EmailRepository emailRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostReported'"
    )
    public void wheneverLostReported_LostMailSend(
        @Payload LostReported lostReported
    ) {
        LostReported event = lostReported;
        System.out.println(
            "\n\n##### listener LostMailSend : " + lostReported + "\n\n"
        );

        // Sample Logic //
        Email.lostMailSend(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LocationSearched'"
    )
    public void wheneverLocationSearched_ServiceMailSend(
        @Payload LocationSearched locationSearched
    ) {
        LocationSearched event = locationSearched;
        System.out.println(
            "\n\n##### listener ServiceMailSend : " + locationSearched + "\n\n"
        );

        // Sample Logic //
        Email.serviceMailSend(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RemoteLocked'"
    )
    public void wheneverRemoteLocked_ServiceMailSend(
        @Payload RemoteLocked remoteLocked
    ) {
        RemoteLocked event = remoteLocked;
        System.out.println(
            "\n\n##### listener ServiceMailSend : " + remoteLocked + "\n\n"
        );

        // Sample Logic //
        Email.serviceMailSend(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DataDeleted'"
    )
    public void wheneverDataDeleted_ServiceMailSend(
        @Payload DataDeleted dataDeleted
    ) {
        DataDeleted event = dataDeleted;
        System.out.println(
            "\n\n##### listener ServiceMailSend : " + dataDeleted + "\n\n"
        );

        // Sample Logic //
        Email.serviceMailSend(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
