package abastian.dwi.saputra.testtechnicaldevelopment.soaltigadevelopment.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {

    @NotNull
    private Integer nid;

    @NotNull
    private Integer officeId;
}
