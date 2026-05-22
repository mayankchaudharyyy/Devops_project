package com.gocomet.auction.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auction_configs")
public class AuctionConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rfq_id")
    private Long rfqId;

    @Column(name = "trigger_window_minutes")
    private Integer triggerWindowMinutes;

    @Column(name = "extension_duration_minutes")
    private Integer extensionDurationMinutes;

    @Column(name = "extension_trigger")
    private String extensionTrigger;
}
