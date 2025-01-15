package dti.application.usecase.enterprise;

import dti.domain.model.Enterprise;

public interface InsertEnterpriseUseCase {

    Enterprise execute(String name);

}
