package com.gmu.tutors;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile(value = "default")
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.gmu.tutors"}, considerNestedRepositories = true)
class ApplicationConfig extends AbstractMongoConfiguration {

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return "gmu_tutors";
    }
}