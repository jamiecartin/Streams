package tech.jasey.streamsschedule.model;

import java.time.LocalDateTime;

public record LiveStream(String id, String title, String description, String url, LocalDateTime startDate, LocalDateTime endDate) {
}
