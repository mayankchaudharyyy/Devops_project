package com.gocomet.auction.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "auction_logs")
public class AuctionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rfq_id")
    private Long rfqId;

    @Column(name = "event_type")
    private String eventType;

    private String description;

    @Column(name = "old_close_time")
    private LocalDateTime oldCloseTime;

    @Column(name = "new_close_time")
    private LocalDateTime newCloseTime;

    @Column(name = "triggered_by_bid_id")
    private Long triggeredByBidId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
