package com.example.maratonchallenge.repositories;

import com.example.maratonchallenge.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PagingAndSortingRepository<Person, Long> {
    Person findByRuc(String ruc);
    Page<Person> findAll(Pageable pageable);
}
