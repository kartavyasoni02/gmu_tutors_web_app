package transfer.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Andrew on 4/29/2017.
 *
 * reading guide for MongoDB integration
 * url: https://spring.io/guides/gs/accessing-mongodb-data-rest/
 */
@Document(collection = "tutor")
@TypeAlias(value = "tutor")
public class MongoTutor {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
