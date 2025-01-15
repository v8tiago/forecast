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

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindAllEnterpriseServiceTest {
    @InjectMocks
    private FindAllEnterpriseService findAllEnterpriseService;

    @Mock
    private EnterprisePort enterprisePort;

    private Enterprise enterprise;

    @BeforeEach
    void setUp() {
        enterprise = Enterprise.builder().id(1).name("enterprise").build();
    }

    @Test
    void testFindAllWithName() {
        when(enterprisePort.findByName("enterprise")).thenReturn(enterprise);

        List<Enterprise> result = findAllEnterpriseService.execute("enterprise");

        assertEquals(1, result.size());
        assertEquals(enterprise, result.getFirst());
    }

    @Test
    void testFindAllWithEmptyName() {
        when(enterprisePort.findAll()).thenReturn(List.of(enterprise));

        List<Enterprise> result = findAllEnterpriseService.execute("");

        assertEquals(1, result.size());
        assertEquals(enterprise, result.getFirst());
    }

    @Test
    void testFindAllWithNameNotFound() {
        when(enterprisePort.findByName("Nonexistent Enterprise")).thenReturn(Enterprise.EMPTY);

        assertThrows(EnterpriseNotFoundException.class, () -> findAllEnterpriseService.execute("Nonexistent Enterprise"));
    }

    @Test
    void testFindAllWithEmptyNameAndNoEnterprises() {
        when(enterprisePort.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EnterpriseNotFoundException.class, () -> findAllEnterpriseService.execute(""));
    }
}