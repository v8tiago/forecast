package dti.infra.persistence.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Serdeable
@Data
@Builder
@Table(name = "enterprise")
public class EnterpriseEntity {

    @GeneratedValue(GeneratedValue.Type.AUTO)
    @Id
    private Integer id;
    private String name;
}
