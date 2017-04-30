import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transfer.collections.MongoTutor;

import javax.annotation.Resource;

/**
 * Created by Andrew on 4/22/2017.
 */
@Service
@Transactional
public class ServiceTest {
    private Logger log = LoggerFactory.getLogger(ServiceTest.class);

    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;

    @Test
    public void simpleTest(){
        MongoTutor mongoTutor = new MongoTutor();
        mongoTutor.setFirstName("Andrew");
        mongoTutor.setLastName("Huynh");
        mongoTemplate.save(mongoTutor, "tutors");
    }
}
