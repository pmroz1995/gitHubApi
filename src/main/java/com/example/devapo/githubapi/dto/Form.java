package com.example.devapo.githubapi.dto;


import lombok.Data;

@Data
public class Form {
    String full_name;
    String description;
    String clone_url;
    String stargazers_count;
    String created_at;

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public String getClone_url() {
        return clone_url;
    }

    public String getStargazers_count() {
        return stargazers_count;
    }

    public String getCreated_at() {
        return created_at;
    }
}
