package com.example.devapo.githubapi.controller;

import com.example.devapo.githubapi.dto.ResponseForm;
import com.example.devapo.githubapi.exceptions.SupportingError;
import com.example.devapo.githubapi.service.ApiService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ApiController {


    private ApiService apiService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    public ApiController(ApiService apiService){
        this.apiService = apiService;
    }

    @GetMapping("/{name}/{repository_name}")
    public ResponseForm method(@PathVariable String name, @PathVariable String repository_name) throws Exception {

        try {
            rabbitTemplate.convertAndSend("PiotrMrozQ", apiService.form(name,repository_name));
            return apiService.form(name, repository_name);
        }catch (Exception ex){
            throw new SupportingError("Invalid username or Repository name");
        }
    }

    @RabbitListener(queues = "PiotrMrozQ")
    public void rabibitSoutPrinter(ResponseForm responseForm){
            System.out.println(responseForm);
    }




}
