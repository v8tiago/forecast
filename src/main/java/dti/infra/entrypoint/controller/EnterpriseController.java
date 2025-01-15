package dti.infra.entrypoint.controller;

import dti.application.usecase.enterprise.FindAllEnterpriseUseCase;
import dti.application.usecase.enterprise.FindEnterpriseByIdUseCase;
import dti.application.usecase.enterprise.InsertEnterpriseUseCase;
import dti.application.usecase.enterprise.UpdateEnterpriseUseCase;
import dti.infra.entrypoint.api.EnterpriseApi;
import dti.infra.entrypoint.dto.enterprise.EnterpriseDto;
import dti.infra.entrypoint.dto.enterprise.EnterpriseRequestDto;
import dti.infra.entrypoint.mapper.EnterpriseMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class EnterpriseController implements EnterpriseApi {

    private final FindEnterpriseByIdUseCase findEnterpriseByIdUseCase;
    private final FindAllEnterpriseUseCase findAllEnterpriseUseCase;
    private final InsertEnterpriseUseCase insertEnterpriseUseCase;
    private final UpdateEnterpriseUseCase updateEnterpriseUseCase;

    private final EnterpriseMapper enterpriseMapper;

    @Override
    public HttpResponse<EnterpriseDto> getEnterprise(Integer id) {
        return
                HttpResponse.ok(
                        enterpriseMapper.toDto(
                                findEnterpriseByIdUseCase.execute(id)));
    }

    @Override
    public HttpResponse<List<EnterpriseDto>> getAllEnterprises(String name) {
        return
                HttpResponse.ok(
                        enterpriseMapper.toDtoList(
                                findAllEnterpriseUseCase.execute(name)));
    }

    @Override
    public HttpResponse<EnterpriseDto> insertEnterprise(EnterpriseRequestDto enterpriseRequestDto) {
        return HttpResponse.created(
                enterpriseMapper.toDto(
                        insertEnterpriseUseCase.execute(enterpriseRequestDto.getName())));
    }

    @Override
    public HttpResponse<EnterpriseDto> updateEnterprise(Integer id, EnterpriseRequestDto enterpriseRequestDto) {
        return HttpResponse.ok(
                enterpriseMapper.toDto(
                        updateEnterpriseUseCase.execute(id, enterpriseRequestDto.getName())));
    }

}
