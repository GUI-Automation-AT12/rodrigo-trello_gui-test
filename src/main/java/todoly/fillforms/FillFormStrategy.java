package todoly.fillforms;

import java.util.Map;

public interface FillFormStrategy {
    boolean fill(Map<String,String> data);
    void sendForm();
}
