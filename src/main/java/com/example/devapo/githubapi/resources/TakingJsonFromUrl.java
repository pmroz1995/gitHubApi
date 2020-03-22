package com.example.devapo.githubapi.resources;

import java.lang.reflect.InvocationTargetException;

public interface TakingJsonFromUrl  {

    String templatedJson(String name, String repository_name) throws InvocationTargetException, Exception;
}
