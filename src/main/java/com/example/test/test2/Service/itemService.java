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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.test2.Domain.Items;
import com.example.test.test2.Dto.ItemsDto;
import com.example.test.test2.Repository.ItemsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class itemService {

    private final ItemsRepository itemsRepository;

    // DB에 저장하는 Service
    @Transactional
    public Items save(ItemsDto itemsDto) {
        Items itemsEntity = itemsRepository.save(itemsDto.toEntity());
        return itemsEntity;
    }

    // DB에서 이름으로 조회후 items 테이블의 code 리턴
    public int getCategoryCode(String id) {
        Optional<Items> itemsEntity = itemsRepository.findByName(id);
        int code = itemsEntity.get().getCode();
        return code;
    }

    public List<Items> getDatabase() {
        List<Items> itemsEntity = new ArrayList<Items>();
        itemsEntity = itemsRepository.findAll();
        return itemsEntity;
    }

    public List<Items> getDatabaseByCode(int code) {
        List<Items> itemsEntity = itemsRepository.findBycode(code);
        return itemsEntity;
    }

    public int getDatabaseCount() {
        long count = itemsRepository.count();
        return (int) count;
    }

    public Page<Items> getItemList(Pageable pageable) {

        return itemsRepository.findAll(pageable);
    }

    public JSONArray getMarketOneItems(String LostarkApiKey, int Id, int CategoryCode, String Name, String Grade) {
        try {
            // API 통신
            URL url = new URL("https://developer-lostark.game.onstove.com/markets/items");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // 서버 연결
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("authorization", "Bearer " + LostarkApiKey);
            httpURLConnection.setRequestProperty("accept", "application/json");
            httpURLConnection.setRequestProperty("content-Type", "application/json");
            httpURLConnection.setDoOutput(true);

            // 수신 데이터 변수 설정
            String parameter = "{\n"
                    + "  \"Sort\": \"CURRENT_MIN_PRICE\",\n"
                    + "  \"CategoryCode\": " + CategoryCode + ",\n"
                    + "  \"ItemGrade\": \"" + Grade + "\",\n"
                    + "  \"ItemName\": \"" + Name + "\",\n"
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
            // 데이터 UTF-8 로 수신하여 한글 깨짐 방지
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            // JSON 형식으로 파싱 후 저장
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(inputStreamReader);
            JSONArray resultJsonArray = (JSONArray) object.get("Items");

            JSONObject jsonObject = new JSONObject();

            resultJsonArray.forEach((data) -> {

                jsonObject.put("Id", ((JSONObject) data).get("Id"));
                jsonObject.put("Name", ((JSONObject) data).get("Name").toString());
                jsonObject.put("CurrentMinPrice", ((JSONObject) data).get("CurrentMinPrice").toString());
                jsonObject.put("Icon", ((JSONObject) data).get("Icon").toString());
                jsonObject.put("categoryCode", CategoryCode);
                jsonObject.put("Grade", ((JSONObject) data).get("Grade").toString());
            });

            JSONArray req_array = new JSONArray();

            req_array.add(jsonObject);
            // 연결 종료
            httpURLConnection.disconnect();

            // JSONArray 반환
            return req_array;

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
}
