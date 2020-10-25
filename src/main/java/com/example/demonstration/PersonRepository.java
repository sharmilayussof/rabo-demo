package com.example.demonstration;


import javafx.scene.control.Pagination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByFirstName(@Param("firstName") String firstName);

    List<Person> findByFirstNameOrLastName(String firstName, String lastName);
    }
