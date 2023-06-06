package saloncey.d4jmmorpg.Services;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class JsonManipulator {

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Autowired
    public JsonManipulator(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = new ObjectMapper();
    }

    public <T> List<T> convert(String jsonString, Class<T> clazz) throws IOException {
        JavaType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
        return objectMapper.readValue(jsonString, listType);
    }

    public String readJsonFile(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filePath);
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
