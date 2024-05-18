package abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.controller;

import abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.model.UserRequest;
import abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.model.UserResponse;
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
@RequestMapping(path = "/soal-satu-development")
public class UserController {

    @Autowired
    private Validator validator;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserResponse create(@RequestBody UserRequest request){
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

        return UserResponse.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

}
