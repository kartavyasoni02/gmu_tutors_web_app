package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import transfer.jpa.JPATutor;

import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 4/22/2017.
 */
@Repository
public interface TutorRepository extends CrudRepository<JPATutor, Long> {
    public List<JPATutor> findByDttmStartAfterAndDttmEndBefore(Date start, Date end);
}
