package dti.infra.entrypoint.controller;

import dti.application.usecase.enterprise.FindAllEnterpriseUseCase;
import dti.application.usecase.enterprise.FindEnterpriseByIdUseCase;
import dti.application.usecase.enterprise.InsertEnterpriseUseCase;
import dti.application.usecase.enterprise.UpdateEnterpriseUseCase;
import dti.domain.model.Enterprise;
import dti.infra.entrypoint.dto.enterprise.EnterpriseRequestDto;
import dti.infra.entrypoint.mapper.EnterpriseMapper;
import io.micronaut.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnterpriseControllerTest {

    @InjectMocks
    EnterpriseController controller;

    @Mock
    FindAllEnterpriseUseCase findAllEnterpriseUseCase;

    @Mock
    FindEnterpriseByIdUseCase findEnterpriseByIdUseCase;

    @Mock
    InsertEnterpriseUseCase insertEnterpriseUseCase;

    @Mock
    UpdateEnterpriseUseCase updateEnterpriseUseCase;

    @Spy
    EnterpriseMapper enterpriseMapper = Mappers.getMapper(EnterpriseMapper.class);


    @Test
    void testGetEnterprise() {
        var enterprise = Enterprise.builder().id(1).name("Test Enterprise").build();
        when(findEnterpriseByIdUseCase.execute(anyInt())).thenReturn(enterprise);

        var response = controller.getEnterprise(1);

        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(enterprise.getName(), response.body().getName());
    }

    @Test
    void testGetAllEnterprises() {
        var enterprise = Enterprise.builder().id(1).name("Test Enterprise").build();
        when(findAllEnterpriseUseCase.execute(anyString())).thenReturn(List.of(enterprise));

        var response = controller.getAllEnterprises("");

        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(1, response.body().size());
    }

    @Test
    void testInsertEnterprise() {
        var enterpriseRequest = EnterpriseRequestDto.builder().name("Test Enterprise").build();
        var enterprise = Enterprise.builder().id(1).name("Test Enterprise").build();
        when(insertEnterpriseUseCase.execute(any())).thenReturn(enterprise);

        var response = controller.insertEnterprise(enterpriseRequest);

        assertEquals(HttpStatus.CREATED, response.getStatus());
        assertEquals(enterprise.getName(), response.body().getName());
    }

    @Test
    void testUpdateEnterprise() {
        var enterpriseRequest = EnterpriseRequestDto.builder().name("Test Enterprise").build();
        var enterprise = Enterprise.builder().id(1).name("Test Enterprise").build();
        when(updateEnterpriseUseCase.execute(anyInt(), anyString())).thenReturn(enterprise);

        var response = controller.updateEnterprise(1, enterpriseRequest);

        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(enterpriseRequest.getName(), response.body().getName());
    }
}