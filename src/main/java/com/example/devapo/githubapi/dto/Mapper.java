package com.example.devapo.githubapi.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {

    public static LocalDateTime  converter(String date){
       return LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }


    public static ResponseForm mapFormToResponseForm(Form form){
        return new ResponseForm()
                .full_name(form.getFull_name())
                .description(form.getDescription())
                .clone_url(form.getClone_url())
                .stars(Integer.parseInt(form.getStargazers_count()))
                .created_at(converter(form.getCreated_at())
                );
    }



}
