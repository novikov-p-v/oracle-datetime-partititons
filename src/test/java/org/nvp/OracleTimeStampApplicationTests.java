package org.nvp;

import org.junit.jupiter.api.Test;
import org.nvp.model.EventInstant;
import org.nvp.model.EventLocalDateTime;
import org.nvp.model.EventOffsetDateTime;
import org.nvp.model.EventTimestamp;
import org.nvp.model.EventZonedDateTime;
import org.nvp.repository.EventInstantRepository;
import org.nvp.repository.EventLocalDateTimeRepository;
import org.nvp.repository.EventOffsetDateTimeRepository;
import org.nvp.repository.EventTimestampRepository;
import org.nvp.repository.EventZonedDateTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class OracleTimeStampApplicationTests {
	@Autowired
    private EventZonedDateTimeRepository eventZonedDateTimeRepository;
    @Autowired
    private EventTimestampRepository eventTimestampRepository;
    @Autowired
    private EventInstantRepository eventInstantRepository;
    @Autowired
    private EventOffsetDateTimeRepository eventOffsetDateTimeRepository;
    @Autowired
    private EventLocalDateTimeRepository eventLocalDateTimeRepository;

    @Test
    void test() {
        ZonedDateTime dateFrom = ZonedDateTime.of(2023, 7, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime dateTo = ZonedDateTime.of(2023, 7, 2, 0, 0, 0, 0 , ZoneId.systemDefault());
        List<EventZonedDateTime>  listZdt = eventZonedDateTimeRepository.findByEventDateTimeBetween(
            dateFrom, dateTo);
        assertFalse(listZdt.isEmpty());

        List<EventTimestamp> listTs = eventTimestampRepository.findByEventDateTimeBetween(
            Timestamp.from(dateFrom.toInstant()),
            Timestamp.from(dateTo.toInstant())
        );
        assertFalse(listTs.isEmpty());

        List<EventInstant> listIns = eventInstantRepository.findByEventDateTimeBetween(
            dateFrom.toInstant(),
            dateTo.toInstant()
        );
        assertFalse(listIns.isEmpty());

        List<EventOffsetDateTime> listOffset = eventOffsetDateTimeRepository.findByEventDateTimeBetween(
            dateFrom.toOffsetDateTime(),
            dateTo.toOffsetDateTime()
        );

        assertFalse(listOffset.isEmpty());

        List<EventLocalDateTime> listLdt = eventLocalDateTimeRepository.findByEventDateTimeBetween(
            dateFrom.toLocalDateTime(),
            dateTo.toLocalDateTime()
        );

        assertFalse(listLdt.isEmpty());

    }
}
