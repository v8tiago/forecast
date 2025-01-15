package dti.application.service.enterprise;

import dti.application.usecase.enterprise.UpdateEnterpriseUseCase;
import dti.domain.exceptions.enterprise.EnterpriseAlreadyExistsException;
import dti.domain.exceptions.enterprise.EnterpriseNotFoundException;
import dti.domain.model.Enterprise;
import dti.domain.port.EnterprisePort;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class UpdateEnterpriseService implements UpdateEnterpriseUseCase {

    private final EnterprisePort enterprisePort;

    @Override
    public Enterprise execute(Integer id, String newName) {
        var enterprise = enterprisePort.findById(id);

        if (Enterprise.EMPTY.equals(enterprise)) {
            throw new EnterpriseNotFoundException(id);
        }

        if (!Enterprise.EMPTY.equals(enterprisePort.findByName(newName))) {
            throw new EnterpriseAlreadyExistsException(newName);
        }

        enterprise.setName(newName);
        return enterprisePort.update(enterprise);
    }
}
