package com.gocomet.auction.repository;

import com.gocomet.auction.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    
    // Get total count of bids for an RFQ
    long countByRfqId(Long rfqId);
    
    // Get count of bids with totalAmount < given amount for an RFQ
    long countByRfqIdAndTotalAmountLessThanAndIdNot(Long rfqId, Double amount, Long excludedBidId);
    
    // Get minimum total amount for an RFQ excluding a specific bid
    @Query("SELECT MIN(b.totalAmount) FROM Bid b WHERE b.rfqId = :rfqId AND b.id != :excludedBidId")
    Double findMinAmountByRfqIdExcludingBidId(Long rfqId, Long excludedBidId);

    // Get minimum total amount for an RFQ
    @Query("SELECT MIN(b.totalAmount) FROM Bid b WHERE b.rfqId = :rfqId")
    Double findMinAmountByRfqId(Long rfqId);
    
    // Get all latest bids per supplier for an RFQ, sorted by total amount
    @Query("SELECT b FROM Bid b " +
           "WHERE b.rfqId = :rfqId " +
           "AND b.id IN (" +
           "  SELECT MAX(b2.id) FROM Bid b2 WHERE b2.rfqId = :rfqId GROUP BY b2.supplierId" +
           ") " +
           "ORDER BY b.totalAmount ASC")
    List<Bid> findLatestBidsPerSupplierByRfqIdSorted(Long rfqId);
}
