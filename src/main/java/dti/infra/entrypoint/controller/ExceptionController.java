package dti.infra.entrypoint.controller;

import dti.domain.exceptions.enterprise.EnterpriseAlreadyExistsException;
import dti.domain.exceptions.enterprise.EnterpriseNotFoundException;
import dti.domain.model.ErrorDomain;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExceptionController {

    @Error(global = true, exception = EnterpriseNotFoundException.class)
    public HttpResponse<ErrorDomain> handleEnterpriseNotFoundException(Exception exception) {
        log.info(exception.getMessage());
        ErrorDomain errorDomain = ErrorDomain.of(exception.getMessage(), HttpStatus.NOT_FOUND.getCode());
        return HttpResponse.<ErrorDomain>notFound().body(errorDomain);
    }

    @Error(global = true, exception = EnterpriseAlreadyExistsException.class)
    public HttpResponse<ErrorDomain> handleEnterpriseAlreadyExistsException(Exception exception) {
        log.info(exception.getMessage());
        ErrorDomain errorDomain = ErrorDomain.of(exception.getMessage(), HttpStatus.BAD_REQUEST.getCode());
        return HttpResponse.<ErrorDomain>badRequest().body(errorDomain);
    }
}
