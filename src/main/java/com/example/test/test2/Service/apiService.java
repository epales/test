package com.example.test.test2.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class apiService {

    public JSONArray getMarketAllItems(String LostarkApiKey, int CategoryCode) throws InterruptedException {
        try {
            URL url = new URL("https://developer-lostark.game.onstove.com/markets/items/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("authorization", "Bearer " + LostarkApiKey);
            httpURLConnection.setRequestProperty("accept", "application/json");
            httpURLConnection.setRequestProperty("content-Type", "application/json");
            httpURLConnection.setDoOutput(true);

            String parameter = "{\n"
                    + "  \"Sort\": \"CURRENT_MIN_PRICE\",\n"
                    + "  \"CategoryCode\": " + CategoryCode + ",\n"
                    + "  \"PageNo\": 1,\n"
                    + "  \"SortCondition\": \"DESC\"\n"
                    + "}";

            byte[] out = parameter.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = httpURLConnection.getOutputStream();
            stream.write(out);

            int result = httpURLConnection.getResponseCode();

            InputStream inputStream;

            if (result == 200) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            if (inputStream == null) {
                return null;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(inputStreamReader);

            int pageNo = 0;
            int pageSize = 10;
            int totalCount = Integer.parseInt(object.get("TotalCount").toString());

            JSONArray jsonArray = new JSONArray();

            while (pageNo * pageSize < totalCount) {
                pageNo++;
                JSONObject data = getMarketOnePageItems(LostarkApiKey, CategoryCode, pageNo);
                JSONArray resultJsonArray = (JSONArray) data.get("Items");
                JSONObject tempJson = new JSONObject();
                for (int i = 0; i < resultJsonArray.size(); i++) {
                    tempJson = (JSONObject) resultJsonArray.get(i);
                    jsonArray.add(tempJson);
                }
                System.out.println("\n" + pageNo + "\n");
                Thread.sleep(700);
            }

            httpURLConnection.disconnect();

            return jsonArray;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getMarketOnePageItems(String LostarkApiKey, int CategoryCode, int pageNo) {
        try {
            URL url = new URL("https://developer-lostark.game.onstove.com/markets/items/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // ���� ����
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("authorization", "Bearer " + LostarkApiKey);
            httpURLConnection.setRequestProperty("accept", "application/json");
            httpURLConnection.setRequestProperty("content-Type", "application/json");
            httpURLConnection.setDoOutput(true);

            String parameter = "{\n"
                    + "  \"Sort\": \"CURRENT_MIN_PRICE\",\n"
                    + "  \"CategoryCode\": " + CategoryCode + ",\n"
                    + "  \"PageNo\": " + pageNo + ",\n"
                    + "  \"SortCondition\": \"DESC\"\n"
                    + "}";

            byte[] out = parameter.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = httpURLConnection.getOutputStream();
            stream.write(out);

            int result = httpURLConnection.getResponseCode();

            InputStream inputStream;
            if (result == 200) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(inputStreamReader);
            httpURLConnection.disconnect();

            return object;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject GetMarketsOptions(String LostarkApiKey) {
        try {
            URL url = new URL("https://developer-lostark.game.onstove.com/markets/options");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // ���� ����
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("authorization", "Bearer " + LostarkApiKey);
            httpURLConnection.setRequestProperty("accept", "application/json");
            httpURLConnection.setRequestProperty("content-Type", "application/json");
            httpURLConnection.setDoOutput(true);
            int result = httpURLConnection.getResponseCode();

            InputStream inputStream;
            if (result == 200) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(inputStreamReader);
            httpURLConnection.disconnect();

            return object;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
