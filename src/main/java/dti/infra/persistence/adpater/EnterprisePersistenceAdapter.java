package dti.infra.persistence.adpater;

import dti.domain.model.Enterprise;
import dti.domain.port.EnterprisePort;
import dti.infra.persistence.mapper.EnterpriseMapper;
import dti.infra.persistence.repository.EnterpriseRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Singleton
public class EnterprisePersistenceAdapter implements EnterprisePort {

    private final EnterpriseRepository enterpriseRepository;
    private final EnterpriseMapper enterpriseMapper;

    @Override
    public Enterprise insert(Enterprise enterprise) {
        var entity = enterpriseRepository.save(enterpriseMapper.toEntity(enterprise));
        return enterpriseMapper.toDomain(entity);
    }

    @Override
    public Enterprise update(Enterprise enterprise) {
        var entity = enterpriseRepository.update(enterpriseMapper.toEntity(enterprise));
        return enterpriseMapper.toDomain(entity);
    }

    @Override
    public void delete(Integer enterpriseId) {
    }

    @Override
    public Enterprise findByName(String name) {
        var optEnterprise = enterpriseRepository.findByName(name);
        if (optEnterprise.isPresent()) {
            return enterpriseMapper.toDomain(optEnterprise.get());
        }
        return Enterprise.EMPTY;
    }

    @Override
    public Enterprise findById(Integer enterpriseId) {
        var optEnterprise = enterpriseRepository.findById(enterpriseId);
        if (optEnterprise.isPresent()) {
            return enterpriseMapper.toDomain(optEnterprise.get());
        }
        return Enterprise.EMPTY;
    }

    @Override
    public List<Enterprise> findAll() {
        var optEnterprise = enterpriseRepository.findAll();
        return enterpriseMapper.toDomainList(optEnterprise);
    }
}
