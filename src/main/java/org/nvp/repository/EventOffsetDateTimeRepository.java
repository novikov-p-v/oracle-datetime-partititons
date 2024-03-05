

package org.nvp.repository;

import org.nvp.model.EventOffsetDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface EventOffsetDateTimeRepository extends JpaRepository<EventOffsetDateTime, Long> {
    List<EventOffsetDateTime> findByEventDateTimeBetween(OffsetDateTime dateFrom, OffsetDateTime dateTo);
}
