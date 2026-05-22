package com.gocomet.auction.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "rfqs")
public class Rfq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_id", unique = true)
    private String referenceId;

    private String name;

    @Column(name = "buyer_id")
    private Long buyerId;

    @Column(name = "pickup_service_date")
    private String pickupServiceDate;

    @Column(name = "bid_start_time")
    private LocalDateTime bidStartTime;

    @Column(name = "bid_close_time")
    private LocalDateTime bidCloseTime;

    @Column(name = "forced_close_time")
    private LocalDateTime forcedCloseTime;

    private String status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
