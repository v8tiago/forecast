package dti.domain.exceptions.enterprise;

public class EnterpriseNotFoundException extends RuntimeException {
    public EnterpriseNotFoundException(Integer id) {
        super("Enterprise com ID = " + id + " não foi encontrado.");
    }

    public EnterpriseNotFoundException() {
        super("Enterprises não foram encontrados.");
    }

}
