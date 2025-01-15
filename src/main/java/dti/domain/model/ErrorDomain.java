package dti.domain.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Serdeable
@Builder
public class ErrorDomain {
    private final String message;
    private final int httpStatus;

    public static ErrorDomain of(String message, int httpStatus) {
        return ErrorDomain.builder().message(message).httpStatus(httpStatus).build();
    }

    public static ErrorDomain of(String message) {
        return ErrorDomain.builder().message(message).build();
    }
}


