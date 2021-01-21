package com.localhost.starter2.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.localhost.starter2.dto.RequestDto;
import com.localhost.starter2.dto.ResponseDto;
import com.localhost.starter2.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TestService testService;

    @Test
    void GivenARequestWithNoParam_WhenPerformedGetHello_ThenShouldReturnDefaultMessage() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/test/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        assertEquals("Hello World", result);
    }

    @Test
    void GivenARequestWithNameParam_WhenPerformedGetHello_ThenShouldReturnParameterizedMessage() throws Exception {
        String name = "Ahmet";
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/api/test/hello")
                    .param("name", name))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        assertThat(result).isEqualTo("Hello " + name);
    }

    @Test
    void GivenTwoNumbers_WhenPerformedPostAdd_ThenShouldReturnSum() throws Exception {
        RequestDto request = new RequestDto(1, 2);
        long mockResult = 100L;
        ResponseDto expected = new ResponseDto(mockResult);
        when(testService.add(anyInt(), anyInt()))
                .thenReturn(mockResult);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/api/test/add")
                        .content(objectMapper.writeValueAsBytes(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                // First way to check the result
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(mockResult))
                .andReturn();

        verify(testService, times(1))
                .add(anyInt(), anyInt());

        // Second way to check the result
        String result = mvcResult.getResponse().getContentAsString();
        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expected));
    }
}