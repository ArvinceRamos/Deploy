package com.ramos.deploy.repository;

import com.ramos.deploy.model.DestinationPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationPriceRepository extends MongoRepository<DestinationPrice, String> {
    DestinationPrice findByDestination(String destination);
}
