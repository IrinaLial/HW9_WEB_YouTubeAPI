package enteties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class YouTubeActivityItemSnippet {
    public String title;
    public String channelTitle;
    public String publishedAt;
    public YouTubeActivityItemThumbnails thumbnails = new YouTubeActivityItemThumbnails();
}