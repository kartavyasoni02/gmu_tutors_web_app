package com.gmu.tutors.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gmu.tutors.transfer.model.MongoTutor;

import java.util.List;

/**
 * Created by Andrew on 4/29/2017.
 *
 */
@Repository
public interface TutorRepository extends MongoRepository<MongoTutor, String>{
    List<MongoTutor> findByLastName(@Param("name") String name);
}
