package com.gmu.tutors.repository;

import com.gmu.tutors.transfer.model.MongoTutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends CrudRepository<MongoTutor, String> {
    List<MongoTutor> findByLastName(String name);
}
