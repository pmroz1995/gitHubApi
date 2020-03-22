package com.example.devapo.githubapi.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ResponseForm implements Serializable {

    String full_name;
    String description;
    String clone_url;
    int stars;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime created_at;

    public ResponseForm full_name(String full_name) {
        this.full_name = full_name;
        return this;
    }

    public ResponseForm description(String description) {
        this.description = description;
        return this;
    }

    public ResponseForm clone_url(String clone_url) {
        this.clone_url = clone_url;
        return this;
    }

    public ResponseForm stars(int stars) {
        this.stars = stars;
        return this;
    }

    public ResponseForm created_at(LocalDateTime  created_at) {
        this.created_at = created_at;
        return this;
    }
}
