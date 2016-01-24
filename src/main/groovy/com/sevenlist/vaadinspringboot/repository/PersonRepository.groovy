package com.sevenlist.vaadinspringboot.repository

import com.sevenlist.vaadinspringboot.domain.Person
import org.springframework.data.repository.Repository

interface PersonRepository extends Repository<Person, Long> {

    List<Person> findByFirstName(String firstName)
}