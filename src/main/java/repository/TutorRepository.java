package repository;

import org.springframework.data.repository.CrudRepository;
import transfer.jpa.JPATutor;

import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 4/22/2017.
 */
public interface TutorRepository extends CrudRepository<JPATutor, Long> {
    public List<JPATutor> findByStartTimeAfterAndEndTimeBefore(Date start, Date end);
}