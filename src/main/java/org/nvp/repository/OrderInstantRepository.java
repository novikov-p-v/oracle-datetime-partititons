

package org.nvp.repository;

import org.nvp.model.EventInstant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface OrderInstantRepository extends JpaRepository<EventInstant, Long> {
    List<EventInstant> findByOrderDateTimeBetween(Instant dateFrom, Instant dateTo);
}
