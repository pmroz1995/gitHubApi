package com.example.devapo.githubapi.service;

import com.example.devapo.githubapi.dto.Form;
import com.example.devapo.githubapi.dto.Mapper;
import com.example.devapo.githubapi.dto.ResponseForm;
import com.example.devapo.githubapi.resources.TakingJsonFromUrl;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApiServiceImpl implements ApiService{

    private TakingJsonFromUrl takingJsonFromUrl;


    @Autowired
    public ApiServiceImpl(TakingJsonFromUrl takingJsonFromUrl){
        this.takingJsonFromUrl = takingJsonFromUrl;
    }


    public ResponseForm form(String owner, String repository_name) throws JsonSyntaxException, Exception {
        String trololo = takingJsonFromUrl.templatedJson(owner,repository_name);
        Gson gson = new Gson();
        Form form = gson.fromJson(trololo,Form.class);

        return Mapper.mapFormToResponseForm(form);
    }



}
