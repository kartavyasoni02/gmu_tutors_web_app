package com.gmu.tutors.repository;

import com.gmu.tutors.domain.JpaTutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends CrudRepository<JpaTutor, Long> {
    List<JpaTutor> findByLastName(String name);

    List<JpaTutor> findByRatingBetween(Double lowerBound, Double upperBound);
}
