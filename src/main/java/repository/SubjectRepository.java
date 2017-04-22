package repository;

import org.springframework.data.repository.CrudRepository;
import transfer.jpa.JPASubject;

import java.util.List;

/**
 * Created by Andrew on 4/22/2017.
 */
public interface SubjectRepository extends CrudRepository <JPASubject, Long> {
    public List<JPASubject> findByTutorId(Long id);
    public List<JPASubject> findByTutorIdIn(List<Long> ids);
}
