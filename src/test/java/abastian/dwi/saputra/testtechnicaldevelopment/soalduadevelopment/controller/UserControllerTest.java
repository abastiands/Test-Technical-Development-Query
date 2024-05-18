package abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.controller;

import abastian.dwi.saputra.testtechnicaldevelopment.error.ExceptionResponse;
import abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.model.UserRequest;
import abastian.dwi.saputra.testtechnicaldevelopment.soalduadevelopment.model.UserResponse;
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
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createUserBadRequest() throws Exception {
        UserRequest request = new UserRequest();
        request.setName("");

        mockMvc.perform(
                post("/soal-dua-development")
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
    void createUserSuccess() throws Exception {
        UserRequest request = new UserRequest();
        request.setName("nama_kandidat");
        request.setAddress("alamat_kandidat");

        mockMvc.perform(
                post("/soal-dua-development")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            UserResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response);
            assertEquals(request.getName(), response.getName());
            assertEquals(request.getAddress(), response.getAddress());
        });
    }
}