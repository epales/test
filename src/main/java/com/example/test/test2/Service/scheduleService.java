package com.example.test.test2.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.test.test2.Domain.Items;
import com.example.test.test2.Dto.ItemsDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class scheduleService {

    private final itemService itemService;
    private final String LostarkApiKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDA0MjM1NTcifQ.cL2_jhVw01l7d3Krwx_8B5JHzaiMx7-mAeyhriyzvqW7P2AY4uZyzq2QLF-i_z1afaeysTuTePIz-KON6UUN0V83jcp7ZVJlBTrViFR266uNxugq4vla1fU7BZ3jyM8laMsul5cV6E4xtw6fSbzuM4YtbSSlYctq3n2CefmuHddWFkkla_oiHn30YPougssiUTOKQIWfFFU2xT86xrjeyusoyW2iBuHFm6lskiMcLZUTgxlPrOT5Q_d5BcoJwokovedh3WSRB5TEtKDG99DFzprjt8P1tOSilbsf8S-cjq9mJFJZKiJFKkl10Eqrfu3QhAmZROHQbo1HHrcfh7liiw";

    @Scheduled(cron = "0 0/2 * ? * 1,2,4,5,6,7")
    public void DbUpdate() {

        int count = itemService.getDatabaseCount();

        List<Items> itemList = itemService.getDatabase();

        LocalTime now;
        DateTimeFormatter formatter;
        String formatedNow;

        System.out.println("DB 업데이트 스케줄러 작동 시작");

        for (int i = 0; i < count; i++) {
            String name = itemList.get(i).name;
            int id = itemList.get(i).code;
            int code = itemList.get(i).categoriesCode;
            String grade = itemList.get(i).grade;

            JSONArray resultJsonArray = itemService.getMarketOneItems(LostarkApiKey, id, code, name, grade);

            if (resultJsonArray != null) {
                resultJsonArray.forEach((data) -> {
                    ItemsDto itemsDto = new ItemsDto((JSONObject) data);
                    itemService.save(itemsDto);
                });
            } else {
                now = LocalTime.now();
                formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                formatedNow = now.format(formatter);
                System.out.println(formatedNow + " - 오류 작동 중지 ");
                continue;
            }
        }
        now = LocalTime.now();
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        formatedNow = now.format(formatter);
        System.out.println(formatedNow);
        System.out.println("DB 업데이트 스케줄러 작동 완료");
    }

    @Scheduled(cron = "0 0/2 0-6,10-23 ? * 3")
    public void sched1() {
        DbUpdate();
    }

}
