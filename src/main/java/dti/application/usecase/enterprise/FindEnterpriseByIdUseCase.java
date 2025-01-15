package dti.application.usecase.enterprise;

import dti.domain.model.Enterprise;

public interface FindEnterpriseByIdUseCase {

    Enterprise execute(Integer enterpriseId);

}
