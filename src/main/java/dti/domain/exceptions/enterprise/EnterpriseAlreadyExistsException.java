package dti.domain.exceptions.enterprise;

public class EnterpriseAlreadyExistsException extends RuntimeException {
    public EnterpriseAlreadyExistsException(String name) {
        super("Enterprise com nome = " + name + ", já existe.");
    }
}
