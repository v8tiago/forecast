package dti.infra.persistence.mapper;

import dti.domain.model.Enterprise;
import dti.infra.persistence.entity.EnterpriseEntity;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jsr330")
@Singleton
public interface EnterpriseMapper {

    EnterpriseEntity toEntity(Enterprise enterprise);

    Enterprise toDomain(EnterpriseEntity enterprise);

    List<Enterprise> toDomainList(List<EnterpriseEntity> enterprises);
}
