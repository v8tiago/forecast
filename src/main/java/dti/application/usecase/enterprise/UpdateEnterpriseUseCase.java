package dti.application.usecase.enterprise;

import dti.domain.model.Enterprise;

public interface UpdateEnterpriseUseCase {

    Enterprise execute(Integer id, String newName);

}
