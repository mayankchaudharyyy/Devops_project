package com.gocomet.auction.repository;

import com.gocomet.auction.model.Rfq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RfqRepository extends JpaRepository<Rfq, Long> {
    
    @Query("SELECT COUNT(r) FROM Rfq r WHERE YEAR(r.createdAt) = :year")
    long countByYear(int year);
    
    List<Rfq> findAllByOrderByCreatedAtDesc();
}
