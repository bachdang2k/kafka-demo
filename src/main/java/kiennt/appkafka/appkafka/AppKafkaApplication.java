package kiennt.appkafka.appkafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class AppKafkaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppKafkaApplication.class, args);
    }

    private final KafkaMessagePublisher kafkaPublisher;

    @Override
    public void run(String... args) throws Exception {

        try {

            UserDelete user = UserDelete.builder()
                    .email("kiennt0927@vivas.com")
                    .profile_id(1234567891011L)
                    .citizen_id("001200034043")
                    .tenant_id(1)
                    .build();

            kafkaPublisher.sendEvents(user);

        } catch (Exception exception) {
            log.error("loi xay ra ", exception);
        }
    }
}
