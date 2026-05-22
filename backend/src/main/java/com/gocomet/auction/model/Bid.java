package com.gocomet.auction.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rfq_id")
    private Long rfqId;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "carrier_name")
    private String carrierName;

    @Column(name = "freight_charges")
    private Double freightCharges;

    @Column(name = "origin_charges")
    private Double originCharges = 0.0;

    @Column(name = "destination_charges")
    private Double destinationCharges = 0.0;

    @Column(name = "transit_time")
    private String transitTime;

    @Column(name = "quote_validity")
    private String quoteValidity;

    // Mapping the total_amount. If it's a generated column in DB, this maps it.
    // If not, using Formula guarantees it's calculated on read.
    @Formula("freight_charges + origin_charges + destination_charges")
    private Double totalAmount;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
