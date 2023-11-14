package model;

import org.junit.jupiter.api.Test;
import tech.jasey.streamsschedule.model.ImmutableLiveStream;
import tech.jasey.streamsschedule.model.LiveStream;
import tech.jasey.streamsschedule.model.MutableLiveStream;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    void create_new_immutable_live_stream() {
        ImmutableLiveStream stream = new ImmutableLiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                "Spring boot is a great option when building REST APIs.",
                "https://www.twitch.tv/jaseys",
                LocalDateTime.of(2023, 11, 11, 11, 30),
                LocalDateTime.of(2023, 11, 11, 12, 30));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle());
    }

    @Test
    void create_new_record_live_stream() {
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                "Spring boot is a great option when building REST APIs.",
                "https://www.twitch.tv/jaseys",
                LocalDateTime.of(2023, 11, 11, 11, 30),
                LocalDateTime.of(2023, 11, 11, 12, 30));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.title());
        assertTrue(stream.getClass().isRecord());
        assertEquals(6, stream.getClass().getRecordComponents().length);
    }
}
