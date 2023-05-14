package com.uttara.aws;

import com.uttara.aws.entity.Person;
import com.uttara.aws.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringbootDynamodbExampleApplication {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getDynamo")
    public String welcome()
    {
        return "Welecome to dynamoDB aws";
    }

    @PostMapping("/savePerson")
    public Person savePerson(@RequestBody Person person) {
        return personRepository.addPerson(person);
    }

    @GetMapping("/getPerson/{personId}")
    public Person findPersonByPersonId(@PathVariable String personId) {
        return personRepository.findPersonByPersonId(personId);
    }

    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestBody Person person) {
        return personRepository.deletePerson(person);
    }

    @PutMapping("/editPerson")
    public String updatePerson(@RequestBody Person person) {
        return personRepository.editPerson(person);
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringbootDynamodbExampleApplication.class, args);
    }

}
