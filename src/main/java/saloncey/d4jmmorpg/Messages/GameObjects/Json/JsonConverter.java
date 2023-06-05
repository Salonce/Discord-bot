package saloncey.d4jmmorpg.Messages.GameObjects.Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import saloncey.d4jmmorpg.Messages.GameObjects.Book;
import saloncey.d4jmmorpg.Messages.GameObjects.Journey;
import saloncey.d4jmmorpg.Messages.GameObjects.Painting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonConverter {

    private final ObjectMapper objectMapper;

    public JsonConverter() {
        this.objectMapper = new ObjectMapper();
    }

    public <T> List<T> convert(String jsonString, Class<T> clazz) throws IOException {
        JavaType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
        return objectMapper.readValue(jsonString, listType);
    }
}
