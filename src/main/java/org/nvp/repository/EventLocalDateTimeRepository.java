

package org.nvp.repository;

import org.nvp.model.EventLocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventLocalDateTimeRepository extends JpaRepository<EventLocalDateTime, Long> {
    List<EventLocalDateTime> findByEventDateTimeBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
