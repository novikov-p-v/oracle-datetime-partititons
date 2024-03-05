package org.nvp.repository;

import org.nvp.model.EventZonedDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface EventZonedDateTimeRepository extends JpaRepository<EventZonedDateTime, Long> {
    List<EventZonedDateTime> findByEventDateTimeBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);
}
