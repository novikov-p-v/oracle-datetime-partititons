

package org.nvp.repository;

import org.nvp.model.EventInstant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface EventInstantRepository extends JpaRepository<EventInstant, Long> {
    List<EventInstant> findByEventDateTimeBetween(Instant dateFrom, Instant dateTo);
}
