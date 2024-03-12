package com.example.test.test2.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
import com.example.test.test2.Domain.CraftItems;
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
        List<Integer[]> arr = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            List<CraftMake> craftMake = itemService.getCraftMakeByCode(data.get(i).code);
            List<CraftItems> craftItems = itemService.getCraftItemsByCode(data.get(i).code);
            List<Items> itemEntity = itemService.getItemsListByName(data.get(i).code);

            if (!craftMake.isEmpty() || !craftItems.isEmpty()) {
                if (data.get(i).categoriesCode == 60000) {
                    int craftPriceAdd = 0;

                    for (int j = 0; j < craftItems.size(); j++) {
                        craftPriceAdd += (craftItems.get(j).number * itemEntity.get(j).currentMinPrice
                                / itemEntity.get(j).bundleCount);
                    }

                    craftPriceAdd += craftMake.get(0).makePrice;

                    arr.add(new Integer[] { craftPriceAdd,
                            (craftMake.get(0).makeNumber * itemEntity.get(0).currentMinPrice) - craftPriceAdd, 1 });
                }
            } else {
                arr.add(new Integer[] { 0, 0, 0 });
            }
        }
        model.addAttribute("data", data);
        model.addAttribute("count", count);
        model.addAttribute("arr", arr);
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
        List<Items> itemEntity = itemService.getItemsListByName(id);
        List<CraftMake> craftMake = itemService.getCraftMakeByCode(id);
        List<CraftItems> craftItems = itemService.getCraftItemsByCode(id);

        List<Integer> craftPrice = new ArrayList<>();

        int craftPriceAdd = 0;
        int price = craftMake.get(0).getMakePrice();

        int makeNumber = craftMake.get(0).getMakeNumber();

        for (int i = 0; i < craftItems.size(); i++) {
            craftPrice
                    .add(craftItems.get(i).number * itemEntity.get(i).currentMinPrice / itemEntity.get(i).bundleCount);

            craftPriceAdd += craftPrice.get(i);
        }

        craftPriceAdd += craftMake.get(0).makePrice;

        model.addAttribute("price", price);
        model.addAttribute("makeNumber", makeNumber);

        model.addAttribute("craftItems", craftItems);
        model.addAttribute("craftPrice", craftPrice);
        model.addAttribute("craftPriceAdd", craftPriceAdd);

        model.addAttribute("main", items);
        model.addAttribute("items", itemEntity);

        return "detail";
    }

    @GetMapping("/accessory")
    public String moveAccessory(Model model) {

        List<Ability> abil = accessoryService.getDatabase();

        model.addAttribute("abil", abil);

        return "test";
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
    @GetMapping("/scroll/list/sonik")
    public ResponseEntity<List<Integer[]>> scrollListSonik(@PageableDefault(page = 0, size = 10) Pageable pageable,
            Model model) {

        List<Items> data = itemService.getDatabase();
        List<Integer[]> arr = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            List<CraftMake> craftMake = itemService.getCraftMakeByCode(data.get(i).code);
            List<CraftItems> craftItems = itemService.getCraftItemsByCode(data.get(i).code);
            List<Items> itemEntity = itemService.getItemsListByName(data.get(i).code);

            if (!craftMake.isEmpty() || !craftItems.isEmpty()) {
                if (data.get(i).categoriesCode == 60000) {
                    int craftPriceAdd = 0;

                    for (int j = 0; j < craftItems.size(); j++) {
                        craftPriceAdd += (craftItems.get(j).number * itemEntity.get(j).currentMinPrice
                                / itemEntity.get(j).bundleCount);
                    }

                    craftPriceAdd += craftMake.get(0).makePrice;
                    arr.add(new Integer[] { craftPriceAdd,
                            (craftMake.get(0).makeNumber * data.get(i).currentMinPrice) - craftPriceAdd, 1 });
                }
            } else {
                arr.add(new Integer[] { 0, 0, 0 });
            }
        }
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), arr.size());
        Page<Integer[]> productListPage = new PageImpl<>(arr.subList(start, end), pageRequest, arr.size());

        return new ResponseEntity<>(productListPage.getContent(), HttpStatus.OK);
    }

}
