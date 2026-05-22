package com.gocomet.auction.repository;

import com.gocomet.auction.model.AuctionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionLogRepository extends JpaRepository<AuctionLog, Long> {
    List<AuctionLog> findAllByRfqIdOrderByCreatedAtAsc(Long rfqId);
}
