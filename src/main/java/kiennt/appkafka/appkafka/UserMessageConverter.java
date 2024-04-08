package kiennt.appkafka.appkafka;

import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.mapping.Jackson2JavaTypeMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserMessageConverter extends JsonMessageConverter {

    public UserMessageConverter() {
        super();

        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
        typeMapper.addTrustedPackages("*");
        typeMapper.setIdClassMapping(Collections.singletonMap("user", UserDelete.class));
        this.setTypeMapper(typeMapper);
    }
}
