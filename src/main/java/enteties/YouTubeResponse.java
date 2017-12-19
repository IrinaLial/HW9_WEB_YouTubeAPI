package enteties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeResponse {
    public ArrayList<YouTubeItem> items = new ArrayList<>();
}