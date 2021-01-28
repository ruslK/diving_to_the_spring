package com.resttemplate.controller;

import com.resttemplate.entity.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers() {
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);
        return responseEntity.getBody();
    }

    @GetMapping("/value/{id}")
    public Object readUser(@PathVariable("id") Integer id) {
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL, Object.class, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> readUser2(@PathVariable("id") Integer id) {
        String URL = URI + "/{id}";
        return restTemplate.getForEntity(URL, User.class, id);
    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostsFromDummyAPI() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id", "lTE5abbDxdjGplutvTuc");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> response = restTemplate
                .exchange("https://dummyapi.io/data/api/user?limit=10",
                        HttpMethod.GET, entity, Object.class);

        return response;
    }
}
