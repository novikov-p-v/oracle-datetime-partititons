package org.nvp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "event_table")
public class EventLocalDateTime {
    @Id
    private Long id;
    @Column(name = "event_date")
    private LocalDateTime eventDateTime;
}
