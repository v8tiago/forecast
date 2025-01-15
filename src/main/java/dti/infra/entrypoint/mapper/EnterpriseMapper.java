package dti.infra.entrypoint.mapper;

import dti.domain.model.Enterprise;
import dti.infra.entrypoint.dto.enterprise.EnterpriseDto;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;

import java.util.List;

@Singleton
@Mapper(componentModel = "jsr330")
public interface EnterpriseMapper {

    EnterpriseDto toDto(Enterprise enterprise);

    List<EnterpriseDto> toDtoList(List<Enterprise> enterprises);
}
