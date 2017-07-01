package com.gmu.tutors.repository;

import com.gmu.tutors.domain.JpaTutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends CrudRepository<JpaTutor, String> {
    List<JpaTutor> findByLastName(String name);
}
