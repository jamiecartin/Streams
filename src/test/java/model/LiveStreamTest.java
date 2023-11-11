package model;

import org.junit.jupiter.api.Test;
import tech.jasey.streamsschedule.model.MutableLiveStream;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LiveStreamTest {

    @Test
    void create_new_mutable_live_stream() {
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building REST APIs with Spring Boot");
        stream.setDescription("Spring Boot is a great option when building REST APIs.");
        stream.setUrl("https://www.twitch.tv/jaseys");
        stream.setStartDate(LocalDateTime.of(2023, 11, 11, 10, 30));
        stream.setEndDate(LocalDateTime.of(2023, 11, 11, 12, 30));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle());
    }
}
