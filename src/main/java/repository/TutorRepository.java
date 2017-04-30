package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import transfer.collections.MongoTutor;

import java.util.List;

/**
 * Created by Andrew on 4/29/2017.
 *
 * url: https://spring.io/guides/gs/accessing-mongodb-data-rest/
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "tutors",path = "tutors")
public interface TutorRepository extends MongoRepository<MongoTutor, String>{
    List<MongoTutor> findByLastName(@Param("name") String name);
}
