package com.gmu.tutors.repository;

import com.gmu.tutors.domain.JpaTutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends CrudRepository<JpaTutor, Long> {
    List<JpaTutor> findAll();
    Page<JpaTutor> findAll(Pageable pageable);

    List<JpaTutor> findByLastName(String name);

    List<JpaTutor> findByRatingBetween(Double lowerBound, Double upperBound);
}
