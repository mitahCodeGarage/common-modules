package publlishers;

import com.mitahcodegarage.kafkapublish.publishers.KafkaPublisher;
import com.mitahcodegarage.models.BatchStatusRecord;
import org.apache.kafka.clients.producer.MockProducer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutionException;

@RunWith(MockitoJUnitRunner.class)
public class KafkaBatchStatusPublisherTest {
    private KafkaPublisher publisher;
    private final String RECORD_ID = "REC_123456";
    private final String KAFKA_TOPIC = "STATUS";

    private MockProducer mockProducer;

    @Before
    public void setup() {
        publisher = new KafkaPublisher<String>();
        mockProducer = new MockProducer<>(true, new StringSerializer(), new StringSerializer());
    }

    @Test
    public void publishTest() throws ExecutionException, InterruptedException {
        //publisher.publish(mockProducer, KAFKA_TOPIC, "createRecordStatus()");
    }

    private BatchStatusRecord createRecordStatus() {
        BatchStatusRecord recordStatus = BatchStatusRecord.Builder.aBatchStatusRecord()
                .withBatchId(RECORD_ID)
                .build();
        return recordStatus;
    }

    private RecordMetadata createRecordMetadata() {
        RecordMetadata recordMetadata = new RecordMetadata(null, 0l, 0, 0l, 0, 0);
        //Future
        return recordMetadata;
    }
}
