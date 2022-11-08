package com.mitahcodegarage.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
@PropertySource("file:properties/mongodb.properties")
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    @Value("${mongo.database.name}")
    String databaseName;

    @Value("${mongo.host.ip}")
    String hostIp;

    @Value("${mongo.host.port}")
    String hostPort;

    @Value("${mongo.database.username}")
    String user;

    @Value("${mongo.database.password}")
    String password;

    @Value("${mapping.base.package}")
    String mappingBasePackage;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoClient mongoClient() {

        ConnectionString connectionString = new ConnectionString("mongodb://"+ user + ":" + password + "@" + hostIp +":" + hostPort);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton(mappingBasePackage);
    }
}
