package org.nvp;

import org.junit.jupiter.api.Test;
import org.nvp.model.EventInstant;
import org.nvp.model.EventTimestamp;
import org.nvp.model.EventZonedDateTime;
import org.nvp.repository.OrderInstantRepository;
import org.nvp.repository.OrderTimestampRepository;
import org.nvp.repository.OrderZonedDateTimeRepository;
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
    private OrderZonedDateTimeRepository orderRepository;
    @Autowired
    private OrderTimestampRepository orderTimestampRepository;
    @Autowired
    private OrderInstantRepository orderInstantRepository;

    @Test
    void test() {
        ZonedDateTime dateFrom = ZonedDateTime.of(2023, 7, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime dateTo = ZonedDateTime.of(2023, 7, 2, 0, 0, 0, 0 , ZoneId.systemDefault());
        List<EventZonedDateTime>  listZdt = orderRepository.findByOrderDateTimeBetween(
            dateFrom, dateTo);
        assertFalse(listZdt.isEmpty());

        List<EventTimestamp> listTs = orderTimestampRepository.findByOrderDateTimeBetween(
            Timestamp.from(dateFrom.toInstant()),
            Timestamp.from(dateTo.toInstant())
        );
        assertFalse(listTs.isEmpty());

        List<EventInstant> listIns = orderInstantRepository.findByOrderDateTimeBetween(
            dateFrom.toInstant(),
            dateTo.toInstant()
        );
        assertFalse(listIns.isEmpty());
    }
}
