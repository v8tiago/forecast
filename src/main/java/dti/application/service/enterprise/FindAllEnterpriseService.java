package dti.application.service.enterprise;

import dti.application.usecase.enterprise.FindAllEnterpriseUseCase;
import dti.domain.exceptions.enterprise.EnterpriseNotFoundException;
import dti.domain.model.Enterprise;
import dti.domain.port.EnterprisePort;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.applicationinsights.core.dependencies.apachecommons.lang3.StringUtils.isEmpty;

@Slf4j
@RequiredArgsConstructor
@Singleton
public class FindAllEnterpriseService implements FindAllEnterpriseUseCase {

    private final EnterprisePort enterprisePort;

    @Override
    public List<Enterprise> execute(String name) {
        List<Enterprise> enterprises = new ArrayList<>();
        if (isEmpty(name)) {
            log.info("get all enterprises");
            enterprises = enterprisePort.findAll();
        } else {
            log.info("get all enterprises with filter name = ".concat(name));
            var enterprise = enterprisePort.findByName(name);
            if (!Enterprise.EMPTY.equals(enterprise)) {
                enterprises = List.of(enterprise);
            }
        }

        if (enterprises.isEmpty()) {
            throw new EnterpriseNotFoundException();
        }

        return enterprises;
    }
}
