package org.nvp.repository;

import org.nvp.model.EventZonedDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface OrderZonedDateTimeRepository extends JpaRepository<EventZonedDateTime, Long> {
    List<EventZonedDateTime> findByOrderDateTimeBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);
}
