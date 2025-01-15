package dti.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Enterprise {
    public static final Enterprise EMPTY = Enterprise.builder().build();
    private Integer id;
    private String name;
}
