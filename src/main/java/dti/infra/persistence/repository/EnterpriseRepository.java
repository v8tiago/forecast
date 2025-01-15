package dti.infra.persistence.repository;

import dti.infra.persistence.entity.EnterpriseEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.SQL_SERVER)
@Repository
public interface EnterpriseRepository extends CrudRepository<EnterpriseEntity, Integer> {

    Optional<EnterpriseEntity> findByName(String name);
}
