package com.example.maratonchallenge.providers.implementations;

import com.example.maratonchallenge.dtos.responses.SunatRucResponseDto;
import com.example.maratonchallenge.providers.SunatProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SunatProviderInmpl  implements SunatProvider {

    @Value("${sunat.url}")
    private String url;

    @Value("${sunat.token}")
    private String token;

    private final RestTemplate restTemplate;

    @Autowired
    public SunatProviderInmpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public SunatRucResponseDto getRuc(String rucNumber) {

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(this.url)
            .queryParam("tipo", 2)
            .queryParam("ruc", rucNumber)
            .queryParam("token", this.token)
            .encode()
            .toUriString();

        return this.restTemplate.getForObject(urlTemplate, SunatRucResponseDto.class);

    }
}
