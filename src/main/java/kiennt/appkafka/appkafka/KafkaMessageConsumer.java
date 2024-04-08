package kiennt.appkafka.appkafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.*;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
//@KafkaListener(id = "1001", topics = {"delete-user", "hnd-user"})
public class KafkaMessageConsumer implements ConsumerSeekAware {

    @Value("${app.topic.name}")
    String topic;

    @Value("${app.topic.name2}")
    String topic2;

    final long offset = 1;

//    @Override
//    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
//        assignments.keySet().forEach(partition -> callback.seek(topic, partition.partition(), offset));
//    }

//    @KafkaHandler
//    public void consumeUser(UserDelete userDelete) {
//        try {
//            log.info("Received: {}", new ObjectMapper().writeValueAsString(userDelete));
//
//            if (userDelete.getTenant_id() == 1) {
//                log.info("Delete user {} in HND platform", userDelete.getEmail());
//            }
//
//        } catch (Exception e) {
//            log.error("loi xay ra ", e);
//        }
//    }
//
//    @KafkaHandler(isDefault = true)
//    public void unknown(Object obj) {
//        log.info("unknown = {}", obj);
//    }

}
