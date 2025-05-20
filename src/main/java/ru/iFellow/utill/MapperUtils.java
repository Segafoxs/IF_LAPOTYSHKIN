package ru.iFellow.utill;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MapperUtils {
    public static <T> T readFromFile(String path, Class<T> tClass, String name, String job)  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rt = objectMapper.readTree(new File(path));
            ((ObjectNode) rt).put("name", name);
            ((ObjectNode) rt).put("job", job);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), rt);
            return objectMapper.readValue(new File(path), tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
