package com.example.test.test2.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.test.test2.Domain.Items;
import com.example.test.test2.Service.itemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class pageController {

    private final itemService itemService;

    @GetMapping("/test")
    public String moveIndex(Model model) {

        List<Items> data = itemService.getDatabase();

        model.addAttribute("data", data);

        return "/indexTest";
    }

    @GetMapping("/")
    public String index(Model model,
            @PageableDefault(page = 0, size = 5, sort = "code", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Items> list = itemService.getItemList(pageable);

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage, 1);
        int endPage = Math.min(nowPage, list.getTotalPages());

        model.addAttribute("data", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "index";
    }

    @GetMapping("/stone")
    public String moveStone() {

        return "/stone";
    }

    @GetMapping("/network")
    public String moveNetwork() {

        return "/network";
    }

    @GetMapping("/detail/{code}")
    public String moveDetail(@PathVariable(name = "code") int id, Model model) {

        List<Items> items = itemService.getDatabaseByCode(id);

        model.addAttribute("items", items);

        return "/detail";
    }

    @GetMapping("/accessory")
    public String moveAccessory() {

        return "/accessory";
    }
}
