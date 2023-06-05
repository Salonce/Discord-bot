package saloncey.d4jmmorpg.Messages.GameObjects.Json;

import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class JsonReader {
    private final ResourceLoader resourceLoader;

    @Autowired
    public JsonReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String readJsonFile(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filePath);
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return new String(bytes, StandardCharsets.UTF_8);
    }
}