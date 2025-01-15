package dti.application.service.enterprise;

import dti.domain.exceptions.enterprise.EnterpriseAlreadyExistsException;
import dti.domain.model.Enterprise;
import dti.domain.port.EnterprisePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InsertEnterpriseServiceTest {

    @Mock
    private EnterprisePort enterprisePort;

    @InjectMocks
    private InsertEnterpriseService insertEnterpriseService;

    @Test
    void testInsertEnterprise() {
        var enterprise = Enterprise.builder().id(1).name("enterprise").build();
        when(enterprisePort.insert(any(Enterprise.class))).thenReturn(enterprise);

        Enterprise result = insertEnterpriseService.execute("enterprise");

        assertEquals(enterprise.getName(), result.getName());
    }

    @Test
    void testInsertEnterpriseAlreadyExists() {
        var existingEnterprise = Enterprise.EMPTY;
        when(enterprisePort.findByName("enterprise")).thenReturn(existingEnterprise);

        assertThrows(EnterpriseAlreadyExistsException.class, () -> insertEnterpriseService.execute("enterprise"));
        verify(enterprisePort, never()).insert(any(Enterprise.class));
    }
}