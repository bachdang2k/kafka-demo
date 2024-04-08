package kiennt.appkafka.appkafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.*;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
//"javatechie-demo2
@KafkaListener(id = "1001", topics = {"delete-user", "hnd-user"})
public class KafkaMessageConsumer implements ConsumerSeekAware {

    @Value("${app.topic.name}")
    String topic;

    @Value("${app.topic.name2}")
    String topic2;

    final long offset = 0;

    @Override
    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
        assignments.keySet().forEach(partition -> callback.seek(topic2, partition.partition(), offset));
        assignments.keySet().forEach(partition -> callback.seek(topic, partition.partition(), offset));
    }

    @KafkaHandler
    public void consumeUser(UserDelete userDelete,
                            @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key,
                            @Header(KafkaHeaders.RECEIVED_PARTITION) String partition,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                            @Header(KafkaHeaders.OFFSET) String offset
                            ) {
        try {
            log.info("Received: {}, topic :{}, partition :{}, offset :{}, key :{}", new ObjectMapper().writeValueAsString(userDelete), topic, partition, offset, key);

            if (userDelete.getTenant_id() == 1) {
                log.info("Delete user {} in HND platform", userDelete.getEmail());
            }

        } catch (Exception e) {
            log.error("loi xay ra ", e);
        }
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object obj) {
        log.info("unknown = {}", obj);
    }

}
