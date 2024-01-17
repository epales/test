package com.example.test.test2.Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.test2.Domain.Items;
import com.example.test.test2.Dto.ItemsDto;
import com.example.test.test2.Service.apiService;
import com.example.test.test2.Service.itemService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class marketController {
    
    private final apiService apiService;
    private final itemService itemService;
    private String LostarkApiKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDA0MjM1NTcifQ.cL2_jhVw01l7d3Krwx_8B5JHzaiMx7-mAeyhriyzvqW7P2AY4uZyzq2QLF-i_z1afaeysTuTePIz-KON6UUN0V83jcp7ZVJlBTrViFR266uNxugq4vla1fU7BZ3jyM8laMsul5cV6E4xtw6fSbzuM4YtbSSlYctq3n2CefmuHddWFkkla_oiHn30YPougssiUTOKQIWfFFU2xT86xrjeyusoyW2iBuHFm6lskiMcLZUTgxlPrOT5Q_d5BcoJwokovedh3WSRB5TEtKDG99DFzprjt8P1tOSilbsf8S-cjq9mJFJZKiJFKkl10Eqrfu3QhAmZROHQbo1HHrcfh7liiw";

    @PostMapping(value = "/api/markets/categories")
    public String marketCategories(@RequestParam (value ="categories")String categories, Model model) throws InterruptedException{
        
        // Service에서 JSONArray 데이터 수신 후 Model로 View에 송신
        JSONArray result = apiService.getMarketAllItems(LostarkApiKey, Integer.parseInt(categories.replace(",", "")));
        if(result == null){
            return "redirect:/";
        } else{
            model.addAttribute("result", result);
            System.out.println("송신 완료 페이지 이동");

            return "/network";
        }
    }

    @PostMapping(value = "/api/markets/item")
    public String marketItem(@RequestParam (value ="code")String Name, Model model) throws InterruptedException{
        JSONArray result = itemService.getMarketOneItems(LostarkApiKey,50000, Name);
        //System.out.println(result);
        
        model.addAttribute("result", result);
        
        return "/network";
    }
    
	@PostMapping("/api/save")
	public String SaveCode(@RequestParam (value ="code")String Name) {
        JSONArray result = itemService.getMarketOneItems(LostarkApiKey,50000, Name);
        if(result != null){
            result.forEach((data) -> {
                System.out.println(((JSONObject ) data).get("CurrentMinPrice").toString());
                ItemsDto itemsDto = new ItemsDto((JSONObject) data);
                itemService.save(itemsDto);
            });
        }
		return "redirect:/";
	}
}
