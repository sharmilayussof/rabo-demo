package com.example.demonstration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/v1")
    public class PersonController {

        @Autowired
        private PersonRepository personRepository;

        @GetMapping("/person")
        public List<Person> getAllPesron() {
            return (List<Person>) personRepository.findAll();
        }

        @GetMapping("/person/{id}")
        public ResponseEntity<Optional<Person>> getPersonById(@PathVariable(value = "id") Long Id)
               {
            Optional<Person> person = personRepository.findById(Id);
            return ResponseEntity.ok().body(person);
        }

    @GetMapping("/person/name/{name}")
    public ResponseEntity<List<Person>> getPersonLastName(@PathVariable(value = "name") String firstName,@PathVariable(value="name") String lastName)
    {
        return ResponseEntity.ok().body(personRepository.findByFirstNameOrLastName(firstName,lastName));
    }

        @PostMapping("/person")
        public Person createPerson(@RequestBody Person p) {
            return personRepository.save(p);
        }


    }
