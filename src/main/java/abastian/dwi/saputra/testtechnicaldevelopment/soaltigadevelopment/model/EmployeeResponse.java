package abastian.dwi.saputra.testtechnicaldevelopment.soaltigadevelopment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private Integer nid;

    private Integer officeId;
}
