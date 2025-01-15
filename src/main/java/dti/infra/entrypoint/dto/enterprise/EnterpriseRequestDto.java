package dti.infra.entrypoint.dto.enterprise;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Serdeable
@Builder
@Schema(name = "EnterpriseRequest")
public class EnterpriseRequestDto {
    @NotEmpty
    String name;
}
