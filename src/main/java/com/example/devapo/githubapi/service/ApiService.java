package com.example.devapo.githubapi.service;

import com.example.devapo.githubapi.dto.ResponseForm;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.lang.reflect.InvocationTargetException;


public interface ApiService {

    ResponseForm form(String owner, String repository_name) throws InvocationTargetException, Exception;





}
