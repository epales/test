package com.example.test.test2.Controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.test.test2.Service.apiService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class pageController{

    private final apiService apiService;
    private String LostarkApiKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDA0MjM1NTcifQ.cL2_jhVw01l7d3Krwx_8B5JHzaiMx7-mAeyhriyzvqW7P2AY4uZyzq2QLF-i_z1afaeysTuTePIz-KON6UUN0V83jcp7ZVJlBTrViFR266uNxugq4vla1fU7BZ3jyM8laMsul5cV6E4xtw6fSbzuM4YtbSSlYctq3n2CefmuHddWFkkla_oiHn30YPougssiUTOKQIWfFFU2xT86xrjeyusoyW2iBuHFm6lskiMcLZUTgxlPrOT5Q_d5BcoJwokovedh3WSRB5TEtKDG99DFzprjt8P1tOSilbsf8S-cjq9mJFJZKiJFKkl10Eqrfu3QhAmZROHQbo1HHrcfh7liiw";

    @GetMapping("/")
    public String moveIndex(Model model) {
        JSONObject result = apiService.GetMarketsOptions(LostarkApiKey);
        model.addAttribute("result", result);
        return "/index";
    }
    
    @PostMapping("/")
    public String returnIndex(Model model) {
        JSONObject result = apiService.GetMarketsOptions(LostarkApiKey);
        model.addAttribute("result", result);
        return "/index";
    }

    @GetMapping("/network")
    public String moveNetwork() {
        
        return "network";
    }
    
}

