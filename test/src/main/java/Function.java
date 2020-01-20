import org.apache.commons.math3.util.Precision;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Function {
    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String Openweathermap() throws ParseException {
        URL url = Function.createUrl(Settings.Open_Weathermap);
        String resultJson = Function.parseUrl(url);
        JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
        JSONArray weatherArray = (JSONArray) weatherJsonObject.get("list");
        JSONObject weather = (JSONObject) weatherArray.get(0);
        JSONObject array_main=(JSONObject) weather.get("main");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("city", Settings.city);
        jsonObject.put("temperature_of_K", array_main.get("temp"));
        return jsonObject.toJSONString();


    }


    public static String Weatherstack() throws ParseException {
        URL url = Function.createUrl(Settings.Weather_Stack);
        String resultJson = Function.parseUrl(url);
        JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
        JSONObject weatherArray = (JSONObject) weatherJsonObject.get("current");
        Long convert_long= (Long) weatherArray.get("temperature");
        double temperature_of_K=5*(convert_long+32)/9+273.15; //конвертация в кельвины
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("city", Settings.city);
        jsonObject.put("temperature_of_K", temperature_of_K);
        return jsonObject.toJSONString();
    }

    public static String Wunderground() throws IOException { //Wunder parse
        String url=Settings.Wunderground;
        Document page= Jsoup.parse(new URL(url),10000);
        Element get_span_html=page.selectFirst("span[class=wu-value wu-value-to]").firstElementSibling();
        String convert_str=get_span_html.text();
        Float temperature=Float.parseFloat(convert_str);
        double temperature_of_K=5*(temperature+32)/9+273.15;    //конвертация в кельвины
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("city", Settings.city);
        jsonObject.put("temperature_of_K", Precision.round(temperature_of_K, 2));
        return jsonObject.toJSONString();
    }
    public static void Result (String x) throws ClassNotFoundException {
        System.out.println(x);
        MySQL.Trans_of_MySql(x);
    }


}