package com.gocomet.auction.repository;

import com.gocomet.auction.model.AuctionConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionConfigRepository extends JpaRepository<AuctionConfig, Long> {
    Optional<AuctionConfig> findByRfqId(Long rfqId);
}
