package com.example.devapo.githubapi.libs;

import com.example.devapo.githubapi.dto.Mapper;
import com.example.devapo.githubapi.dto.ResponseForm;
import org.springframework.stereotype.Component;

@Component
public class MockData {


    public static ResponseForm responseForm(){
        return new ResponseForm()
                .full_name("pmroz1995/trlolololo")
                .description(null)
                .clone_url("https://github.com/pmroz1995/trlolololo.git")
                .stars(0)
                .created_at(Mapper.converter("2020-03-03T21:28:48Z")
        );

    }


}
