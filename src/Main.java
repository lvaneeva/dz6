import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

         OkHttpClient client = new OkHttpClient();
        //http://dataservice.accuweather.com/forecasts/v1/daily/5day/474212_PC?apikey=HBAoYTHBeloWennir9bjrNSNYgoGaCqz&language=ru-ru&metric=true
        //http://dataservice.accuweather.com/forecasts/v1/daily/5day/474212_PC?apikey=zavI4ltX1xGfiypkhQ0nSYKTOR3PP6q0&language=ru-ru&metric=true        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("474212_PC")
                .addQueryParameter("apikey", "B9ZwmXuOpCmBlYCtAFMASK9mjt6TIAXm")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());

        // При необходимости указать заголовки
        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);
    }
}