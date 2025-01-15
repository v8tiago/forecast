package dti.application.service.enterprise;

import dti.domain.exceptions.enterprise.EnterpriseNotFoundException;
import dti.domain.model.Enterprise;
import dti.domain.port.EnterprisePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindEnterpriseByIdServiceTest {

    @Mock
    private EnterprisePort enterprisePort;

    @InjectMocks
    private FindEnterpriseByIdService findEnterpriseByIdService;

    private Enterprise enterprise;

    @BeforeEach
    void setUp() {
        enterprise = Enterprise.builder().id(1).name("enterprise").build();
    }

    @Test
    void testExecuteWithValidId() {
        when(enterprisePort.findById(1)).thenReturn(enterprise);

        Enterprise result = findEnterpriseByIdService.execute(1);

        assertEquals(enterprise, result);
    }

    @Test
    void testExecuteWithInvalidId() {
        when(enterprisePort.findById(2)).thenReturn(Enterprise.EMPTY);

        assertThrows(EnterpriseNotFoundException.class, () -> findEnterpriseByIdService.execute(2));
    }
}