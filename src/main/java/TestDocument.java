import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public enum  TestDocument {
    SC;

    private Map<String, TestDocuments> docs;
    private TestDocument(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            docs = objectMapper.readValue(new File("target/car.json"), new TypeReference<Map<String, TestDocuments>>() { });
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error("Can't read json file");
        }
    }

    public TestDocuments data(){
        return docs.get(name());
    }
}
