package kiennt.appkafka.appkafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaMessagePublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.topic.name}")
    private String topic;

    @Value("${app.topic.name2}")
    private String topic1;

    public void sendEvents(UserDelete userDelete) {

        try {

            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, userDelete);

            future.whenComplete((result, ex) -> {

                if (ex == null) {
                    System.out.println("Sent message=[" + userDelete.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            userDelete.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception e) {
            log.error("loi xay ra ", e);
        }
    }


    public void sendEventsNew(UserDelete userDelete) {

        try {

            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("hnd-user", "key", userDelete);

            future.whenComplete((result, ex) -> {

                if (ex == null) {
                    System.out.println("Sent message=[" + userDelete.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            userDelete.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception e) {
            log.error("loi xay ra ", e);
        }
    }

}
