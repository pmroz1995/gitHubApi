package com.example.devapo.githubapi.resources;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Component
public class TakingJsonFromUrlImpl implements TakingJsonFromUrl{

    private static final String HEADER_NAME = "Authorization";
    private static final String TOKEN = "Basic cG1yb3oxOTk1Ok1yb3pvbGFuZGlhMQ==";
    private static final String GIT_HUB_URL = "https://api.github.com/repos/";
    private static final String URL_BUILDER_EXCEPTION = "Owner and Repository, Cannot be empty if you want two do this request";

    public TakingJsonFromUrlImpl(){
    }

    private String urlBuilder(String name, String repository_name){
        if(Objects.isNull(name)||Objects.isNull(repository_name)||name.equals("")||repository_name.equals("")){
            throw new IllegalArgumentException(URL_BUILDER_EXCEPTION);
        }
        return GIT_HUB_URL+name+"/"+repository_name;
    }

    public String templatedJson(String name, String repository_name) throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HEADER_NAME, TOKEN);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange(urlBuilder(name,repository_name),
                HttpMethod.GET,
                httpEntity,
                String.class);

        return exchange.getBody();
    }


}
