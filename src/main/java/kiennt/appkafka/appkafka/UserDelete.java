package kiennt.appkafka.appkafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDelete {

    @JsonProperty("tenant_id")
    private Integer tenant_id;

    @JsonProperty("profile_id")
    private Long profile_id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("citizen_id")
    private String citizen_id;

}
