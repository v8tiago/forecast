package dti.infra.entrypoint.dto.enterprise;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Serdeable
@Data
@Schema(name = "Enterprise")
@Builder
public class EnterpriseDto {
    private Integer id;
    private String name;
}
