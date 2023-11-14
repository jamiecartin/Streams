package repository;

import model.LiveStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                "Spring boot is a great option when building REST APIs.",
                "https://www.twitch.tv/jaseys",
                LocalDateTime.of(2023, 11, 11, 11, 30),
                LocalDateTime.of(2023, 11, 11, 12, 30)));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) {
        return streams.stream()
                .filter(stream -> stream.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public LiveStream update(LiveStream stream) {
        LiveStream existingStream = findById(stream.id());
        if (existingStream == null) {
            return null;
        }
        streams.remove(existingStream);
        streams.add(stream);
        return stream;
    }

    public void delete(String id) {
        LiveStream existingStream = findById(id);
        if (existingStream == null) {
            return;
        }
        streams.remove(existingStream);
    }
}
