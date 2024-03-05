
package org.nvp.repository;

import org.nvp.model.EventTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface EventTimestampRepository extends JpaRepository<EventTimestamp, Long> {
    List<EventTimestamp> findByEventDateTimeBetween(Timestamp dateFrom, Timestamp dateTo);
}
