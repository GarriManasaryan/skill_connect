package com.freelance.skc.port.adapters.persistence.postgresql.common;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Optional;

public class PostgresqlNormalizer {

    public static String toTimestamp(OffsetDateTime offsetDateTime) {
        return offsetDateTime != null ? new Timestamp(1000 * offsetDateTime.toEpochSecond()).toString() : "null";
    }

}
