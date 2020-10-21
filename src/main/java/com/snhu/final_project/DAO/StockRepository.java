package com.snhu.final_project.DAO;

import com.snhu.final_project.Models.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface StockRepository extends MongoRepository<Stock, Integer> {

    Optional<Stock> findById(String id);

    Optional<Stock> findByTicker(String ticker);

    @Query(sort = "{ price : -1 }")
    Collection<Stock> findTop5ByIndustry(String industry);
}
