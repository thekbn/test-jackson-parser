import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String...args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, TestDocuments> m = new HashMap<>();

        TestDocuments t = new TestDocuments();
        t.name = "a";
        t.docId = 123;
        m.put("SC", t);
        m.put("TAX1", t);
        objectMapper.writeValue(new File("target/car.json"), m);

        Map<String, TestDocuments> t2 = objectMapper.readValue(new File("target/car.json"), new TypeReference<Map<String, TestDocuments>>() { });
        System.out.println(t2.get("SC").name);

        System.out.println("x: " + TestDocument.SC.data().docId);
    }
}
