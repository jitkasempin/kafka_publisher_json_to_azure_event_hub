//Copyright (c) Microsoft Corporation. All rights reserved.
//Licensed under the MIT License.
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;

public class TestDataReporter implements Runnable {

    private static final int NUM_MESSAGES = 100;
    private final String TOPIC;

    private Producer<Long, JsonNode> producer;   //Original is String

    public TestDataReporter(final Producer<Long, JsonNode> producer, String TOPIC) {
        this.producer = producer;
        this.TOPIC = TOPIC;
    }

    @Override
    public void run() {
        try {

            for(int i = 0; i < NUM_MESSAGES; i++) {
                long time = System.currentTimeMillis();
                System.out.println("Test Data #" + i + " from thread #" + Thread.currentThread().getId());

                String jsonString = "{ \"trackid\":\"5\" }";
                ObjectMapper mapper = new ObjectMapper();
                JsonNode actualObj = mapper.readTree(jsonString);


                final ProducerRecord<Long, JsonNode> record = new ProducerRecord<Long, JsonNode>(TOPIC, time, actualObj);
                producer.send(record, new Callback() {
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception != null) {
                            System.out.println(exception);
                            System.exit(1);
                        }
                    }
                });
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finished sending " + NUM_MESSAGES + " messages from thread #" + Thread.currentThread().getId() + "!");
    }
}