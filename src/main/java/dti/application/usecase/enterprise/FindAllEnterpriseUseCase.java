package dti.application.usecase.enterprise;

import dti.domain.model.Enterprise;

import java.util.List;

public interface FindAllEnterpriseUseCase {

    List<Enterprise> execute(String name);

}
