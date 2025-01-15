package dti.domain.port;

import dti.domain.model.Enterprise;

import java.util.List;

public interface EnterprisePort {
    Enterprise insert(Enterprise enterprise);

    Enterprise update(Enterprise enterprise);

    void delete(Integer enterpriseId);

    Enterprise findByName(String name);

    Enterprise findById(Integer enterpriseId);

    List<Enterprise> findAll();
}
