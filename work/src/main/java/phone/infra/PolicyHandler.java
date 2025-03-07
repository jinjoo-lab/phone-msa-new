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
    WorkRepository workRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LockRequested'"
    )
    public void wheneverLockRequested_RemoteLock(
        @Payload LockRequested lockRequested
    ) {
        LockRequested event = lockRequested;
        System.out.println(
            "\n\n##### listener RemoteLock : " + lockRequested + "\n\n"
        );

        // Sample Logic //
        Work.remoteLock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostReported'"
    )
    public void wheneverLostReported_LocationSearch(
        @Payload LostReported lostReported
    ) {
        LostReported event = lostReported;
        System.out.println(
            "\n\n##### listener LocationSearch : " + lostReported + "\n\n"
        );

        // Sample Logic //
        Work.locationSearch(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DataDeleteRequested'"
    )
    public void wheneverDataDeleteRequested_DataDelete(
        @Payload DataDeleteRequested dataDeleteRequested
    ) {
        DataDeleteRequested event = dataDeleteRequested;
        System.out.println(
            "\n\n##### listener DataDelete : " + dataDeleteRequested + "\n\n"
        );

        // Sample Logic //
        Work.dataDelete(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
