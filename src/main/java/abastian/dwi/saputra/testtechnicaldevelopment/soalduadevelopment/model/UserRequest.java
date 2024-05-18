package abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;
}
