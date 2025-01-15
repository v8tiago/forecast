package dti.application.service.enterprise;

import dti.application.usecase.enterprise.InsertEnterpriseUseCase;
import dti.domain.exceptions.enterprise.EnterpriseAlreadyExistsException;
import dti.domain.model.Enterprise;
import dti.domain.port.EnterprisePort;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class InsertEnterpriseService implements InsertEnterpriseUseCase {

    private final EnterprisePort enterprisePort;

    @Override
    public Enterprise execute(String name) {
        log.info("insert enterprise with name = ".concat(name));
        if (Enterprise.EMPTY.equals(enterprisePort.findByName(name.toLowerCase()))) {
            throw new EnterpriseAlreadyExistsException(name);
        }
        var enterprise = Enterprise.builder().name(name).build();
        return enterprisePort.insert(enterprise);
    }

}
