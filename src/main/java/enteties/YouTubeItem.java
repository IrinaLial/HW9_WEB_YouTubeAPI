package enteties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeItem {
    private YouTubeId id;
    public YouTubeActivityItemSnippet snippet = new YouTubeActivityItemSnippet();

    public String getId ( ) {
        return id.videoId;
    }
}
