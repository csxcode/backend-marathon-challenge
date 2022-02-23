package com.example.maratonchallenge.services.implementations;

import com.example.maratonchallenge.dtos.commons.PaginationResponse;
import com.example.maratonchallenge.dtos.requests.PaginationPageRequestDto;
import com.example.maratonchallenge.dtos.requests.SunatRucRequestDto;
import com.example.maratonchallenge.dtos.responses.PersonResponseDto;
import com.example.maratonchallenge.dtos.responses.PersonSearchResponseDto;
import com.example.maratonchallenge.entities.Person;
import com.example.maratonchallenge.exceptions.NotFoundException;
import com.example.maratonchallenge.repositories.PersonRepository;
import com.example.maratonchallenge.services.PersonService;
import com.example.maratonchallenge.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PaginationResponse<PersonSearchResponseDto> search(PaginationPageRequestDto dto) {
        Pageable pageable  = PageRequest.of(dto.page, dto.limit);
        Page<Person> data = this.personRepository.findAll(pageable);

        return DtoMapper.mapPage(data, PersonSearchResponseDto.class);
    }

    @Override
    public PersonResponseDto create(SunatRucRequestDto dto) {
        boolean exists = this.personRepository.findByRuc(dto.getRuc()) != null;

        if(exists)
            throw new NotFoundException("Ruc already exists in our records");

        Person entity = new Person();
        entity.setRuc(dto.getRuc());
        entity.setDepartamento(dto.getDepartamento());
        entity.setDireccion(dto.getDireccion());
        entity.setDistrito(dto.getDistrito());
        entity.setEstado(dto.getEstado());
        entity.setProvincia(dto.getProvincia());
        entity.setRazon_social(dto.getRazon_social());
        entity.setUbigeo(dto.getUbigeo());

        return DtoMapper.map(this.personRepository.save(entity), PersonResponseDto.class);
    }
}

