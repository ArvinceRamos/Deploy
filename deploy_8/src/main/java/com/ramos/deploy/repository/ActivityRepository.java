package com.ramos.deploy.repository;

import com.ramos.deploy.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    List<Activity> findByBangkasNameContainingIgnoreCase(String bangkasName);
}
