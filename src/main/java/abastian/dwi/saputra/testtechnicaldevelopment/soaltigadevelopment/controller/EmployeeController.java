package abastian.dwi.saputra.testtechnicaldevelopment.soaltigadevelopment.controller;

import abastian.dwi.saputra.testtechnicaldevelopment.soaltigadevelopment.model.EmployeeRequest;
import abastian.dwi.saputra.testtechnicaldevelopment.soaltigadevelopment.model.EmployeeResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/soal-tiga-development")
public class EmployeeController {

    @Autowired
    private Validator validator;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public EmployeeResponse create(@RequestBody EmployeeRequest request){
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

        return EmployeeResponse.builder()
                .nid(request.getNid())
                .officeId(request.getOfficeId())
                .build();
    }

}
