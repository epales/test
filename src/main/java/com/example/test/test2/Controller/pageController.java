package com.example.test.test2.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.test2.Domain.Ability;
import com.example.test.test2.Domain.CraftMake;
import com.example.test.test2.Domain.Items;
import com.example.test.test2.Service.accessoryService;
import com.example.test.test2.Service.itemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class pageController {

    private final itemService itemService;
    private final accessoryService accessoryService;

    @GetMapping("/")
    public String moveIndex(Model model) {
        List<Items> data = itemService.getDatabase();
        int count = itemService.getDatabaseCount();

        model.addAttribute("data", data);
        model.addAttribute("count", count);

        return "index";
    }

    @GetMapping("/stone")
    public String moveStone() {

        return "stone";
    }

    @GetMapping("/network")
    public String moveNetwork() {

        return "network";
    }

    @GetMapping("/detail/{code}")
    public String moveDetail(@PathVariable(name = "code") int id, Model model) {

        List<Items> items = itemService.getDatabaseByCode(id);
        List<Items> itemEntity = itemService.getCraftItemsListByName(id);
        List<CraftMake> craftMake = itemService.getCraftMakeByCode(id);
        if (!craftMake.isEmpty()) {
            int price = craftMake.get(0).getMakePrice();
            int makeNumber = craftMake.get(0).getMakeNumber();
            model.addAttribute("price", price);
            model.addAttribute("makeNumber", makeNumber);
        } else {
            model.addAttribute("makeNumber", 0);
        }
        model.addAttribute("main", items);
        model.addAttribute("items", itemEntity);

        return "detail";
    }

    @GetMapping("/accessory")
    public String moveAccessory(Model model) {

        List<Ability> abil = accessoryService.getDatabase();

        model.addAttribute("abil", abil);

        return "accessory";
    }

    @GetMapping("/auction")
    public String moveAuction(Model model) {

        return "auction";
    }

    @GetMapping("/inchant")
    public String moveInchant(Model model) {

        return "inchant";
    }

    @ResponseBody
    @GetMapping("/scroll/list")
    public ResponseEntity<List<Items>> scrollList(@PageableDefault(page = 0, size = 10) Pageable pageable,
            Model model) {
        Page<Items> productListPage = itemService.getItemList(pageable);

        return new ResponseEntity<>(productListPage.getContent(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/access/list")
    public ResponseEntity<List<Ability>> accessList() {

        List<Ability> abil = accessoryService.getDatabase();

        return new ResponseEntity<>(abil, HttpStatus.OK);
    }
}
