package dti.application.service.enterprise;

import dti.domain.exceptions.enterprise.EnterpriseAlreadyExistsException;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateEnterpriseServiceTest {

    @Mock
    private EnterprisePort enterprisePort;

    @InjectMocks
    private UpdateEnterpriseService updateEnterpriseService;

    private Enterprise existingEnterprise;

    @BeforeEach
    void setUp() {
        existingEnterprise = Enterprise.builder().id(1).name("Existing Enterprise").build();
    }

    @Test
    void testUpdateEnterpriseWithValidIdAndNewName() {
        when(enterprisePort.findById(1)).thenReturn(existingEnterprise);
        when(enterprisePort.findByName("New Enterprise")).thenReturn(Enterprise.EMPTY);
        when(enterprisePort.update(any(Enterprise.class))).thenReturn(existingEnterprise);

        Enterprise result = updateEnterpriseService.execute(1, "New Enterprise");

        assertEquals("New Enterprise", result.getName());
        verify(enterprisePort).update(existingEnterprise);
    }

    @Test
    void testUpdateEnterpriseWithInvalidId() {
        when(enterprisePort.findById(2)).thenReturn(Enterprise.EMPTY);

        assertThrows(EnterpriseNotFoundException.class, () -> updateEnterpriseService.execute(2, "New Enterprise"));
        verify(enterprisePort, never()).update(any(Enterprise.class));
    }

    @Test
    void testUpdateEnterpriseWithExistingName() {
        when(enterprisePort.findById(1)).thenReturn(existingEnterprise);
        when(enterprisePort.findByName("Existing Enterprise")).thenReturn(existingEnterprise);

        assertThrows(EnterpriseAlreadyExistsException.class, () -> updateEnterpriseService.execute(1, "Existing Enterprise"));
        verify(enterprisePort, never()).update(any(Enterprise.class));
    }
}