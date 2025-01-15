package dti.application.service.enterprise;

import dti.application.usecase.enterprise.FindEnterpriseByIdUseCase;
import dti.domain.exceptions.enterprise.EnterpriseNotFoundException;
import dti.domain.model.Enterprise;
import dti.domain.port.EnterprisePort;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Singleton
public class FindEnterpriseByIdService implements FindEnterpriseByIdUseCase {

    private final EnterprisePort enterprisePort;

    @Override
    public Enterprise execute(Integer enterpriseId) {
        log.info("get enterprise with id = ".concat(enterpriseId.toString()));
        var enterprise = enterprisePort.findById(enterpriseId);
        if (Enterprise.EMPTY.equals(enterprise)) {
            throw new EnterpriseNotFoundException(enterpriseId);
        }
        return enterprise;
    }
}
