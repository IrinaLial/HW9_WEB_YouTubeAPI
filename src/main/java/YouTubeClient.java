import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import enteties.YouTubeResponse;
import properties.YouTubeProperties;

import java.io.IOException;
import java.util.Properties;

public class YouTubeClient {

    private static Properties properties =  YouTubeProperties.loadPPropertiesFromFile("src/main/resources/youtube.properties");

    static {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private YouTubeClient (){}

    public static HttpResponse<YouTubeResponse> getActivities( String channelId, int maxResults) {
        try {
            return Unirest.get(properties.getProperty("YOU_TUBE"))
                    .routeParam("method", "activities")
                    .queryString("channelId", channelId)
                    .queryString("maxResults", maxResults)
                    .queryString("part", "snippet")
                    .queryString("key", properties.getProperty("API_KEY"))
                    .asObject( YouTubeResponse.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HttpResponse<YouTubeResponse> getSearchResult( String query, int maxResults) {
        try {
            return Unirest.get(properties.getProperty("YOU_TUBE"))
                    .routeParam("method", "search")
                    .queryString("q", query)
                    .queryString("maxResults", maxResults)
                    .queryString("part", "snippet")
                    .queryString("key", properties.getProperty("API_KEY"))
                    .asObject( YouTubeResponse.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
