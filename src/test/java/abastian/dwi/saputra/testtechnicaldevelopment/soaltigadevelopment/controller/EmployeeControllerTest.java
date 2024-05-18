package abastian.dwi.saputra.testtechnicaldevelopment.soaltigadevelopment.controller;

import abastian.dwi.saputra.testtechnicaldevelopment.error.ExceptionResponse;
import abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.model.UserRequest;
import abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.model.UserResponse;
import abastian.dwi.saputra.testtechnicaldevelopment.soaltigadevelopment.model.EmployeeRequest;
import abastian.dwi.saputra.testtechnicaldevelopment.soaltigadevelopment.model.EmployeeResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createEmployeeBadRequest() throws Exception {
        EmployeeRequest request = new EmployeeRequest();
        request.setNid(null);

        mockMvc.perform(
                post("/soal-tiga-development")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            ExceptionResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response);
        });
    }

    @Test
    void createEmployeeSuccess() throws Exception {
        EmployeeRequest request = new EmployeeRequest();
        request.setNid(10);
        request.setOfficeId(3);

        mockMvc.perform(
                post("/soal-tiga-development")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            EmployeeResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response);
            assertEquals(request.getNid(), response.getNid());
            assertEquals(request.getOfficeId(), response.getOfficeId());
        });
    }
}