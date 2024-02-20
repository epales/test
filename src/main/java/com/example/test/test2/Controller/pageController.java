package com.example.test.test2.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.test2.Domain.Items;
import com.example.test.test2.Service.itemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class pageController {

    private final itemService itemService;

    @GetMapping("/")
    public String moveIndex(Model model) {

        List<Items> data = itemService.getDatabase();
        int count = itemService.getDatabaseCount();
        System.out.println(count);
        model.addAttribute("data", data);
        model.addAttribute("count", count);

        return "/index";
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

    @ResponseBody
    @GetMapping("/scroll/list")
    public ResponseEntity<List<Items>> scrollList(@PageableDefault(page = 0, size = 10) Pageable pageable,
            Model model) {

        // Repository 에 Paging 정보를 요청하기 위해 Pageable 객체 생성 (page, size, 정렬 정보)
        // Pageable sortedByIdDesc = PageRequest.of(pageable.getPageNumber(),
        // pageable.getPageSize(),
        // Sort.by("code").descending());
        Page<Items> productListPage = itemService.getItemList(pageable);

        // System.out.println("값1:" + sortedByIdDesc);
        // System.out.println("값1:" + productListPage);
        // System.out.println("값2:" + new ResponseEntity<>(productListPage.getContent(),
        // HttpStatus.OK));
        // List<Entity> 정보를 넘겨주기 위해 ResponseEntity 사용
        return new ResponseEntity<>(productListPage.getContent(), HttpStatus.OK);
    }
}
