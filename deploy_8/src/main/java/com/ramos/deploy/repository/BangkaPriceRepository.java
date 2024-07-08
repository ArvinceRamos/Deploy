package com.ramos.deploy.repository;

import com.ramos.deploy.model.BangkaPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BangkaPriceRepository extends MongoRepository<BangkaPrice, String> {
    BangkaPrice findByBangkaName(String bangkaName);
}
