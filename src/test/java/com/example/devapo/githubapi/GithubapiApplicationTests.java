
package com.example.devapo.githubapi;

import com.example.devapo.githubapi.controller.ApiController;
import com.example.devapo.githubapi.libs.MockData;
import com.example.devapo.githubapi.service.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@WebMvcTest(ApiController.class)
class GithubapiApplicationTests  {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ApiService apiService;

    @Test
    public void full_name_should_be_the_same() throws Exception{

        when(apiService.form("pmroz1995", "trlolololo")).thenReturn(MockData.responseForm());

        ResultActions resultActions = this.mockMvc.perform(

                MockMvcRequestBuilders
                        .get("http://localhost:8080/{name}/{surname}", "pmroz1995", "trlolololo")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(status().isOk())
                .andExpect(content().json("{\"full_name\":\"pmroz1995/trlolololo\"}"));
    }

    @Test
    public void description_should_be_the_same() throws Exception{

        when(apiService.form("pmroz1995", "trlolololo")).thenReturn(MockData.responseForm());

        ResultActions resultActions = this.mockMvc.perform(

                MockMvcRequestBuilders
                        .get("http://localhost:8080/{name}/{surname}", "pmroz1995", "trlolololo")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(status().isOk())
                .andExpect(content().json("{\"description\":null}"));
    }


    @Test
    public void cloneUrl_should_be_the_same() throws Exception{

        when(apiService.form("pmroz1995", "trlolololo")).thenReturn(MockData.responseForm());

        ResultActions resultActions = this.mockMvc.perform(

                MockMvcRequestBuilders
                        .get("http://localhost:8080/{name}/{surname}", "pmroz1995", "trlolololo")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(status().isOk())
                .andExpect(content().json("{\"clone_url\":\"https://github.com/pmroz1995/trlolololo.git\"}"));
    }

    @Test
    public void stars_should_be_the_same() throws Exception{

        when(apiService.form("pmroz1995", "trlolololo")).thenReturn(MockData.responseForm());

        ResultActions resultActions = this.mockMvc.perform(

                MockMvcRequestBuilders
                        .get("http://localhost:8080/{name}/{surname}", "pmroz1995", "trlolololo")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(status().isOk())
                .andExpect(content().json("{\"stars\":0}"));
    }

}

