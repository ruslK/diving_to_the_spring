package com.restproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restproject.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private String city;
    private String country;
    private Integer currentTemperature;
    private String postalCode;
    private String state;
    private String Street;

//    @OneToOne(mappedBy = "address")
//    @JsonBackReference
//    private Student student;

//    @OneToOne(mappedBy = "address")
//    @JsonIgnore
//    private Parent parent;

//    @OneToOne(mappedBy = "address")
//    @JsonBackReference
//    private Teacher teacher;

    public Integer consumeTemp(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String BASE_URL = "http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=";
        String uri = BASE_URL + city;
        Object currentWeather = restTemplate.getForObject(uri, Object.class);
        Map<String, Object> getWeather = (Map<String, Object>) currentWeather;
        Map<String, Object> getTemperature = (Map<String, Object>) getWeather.get("current");

        return Integer.parseInt(getTemperature.get("temperature").toString());
    }

}
