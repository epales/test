package com.example.test.test2.Dto;

import org.json.simple.JSONObject;

import com.example.test.test2.Domain.Items;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ItemsDto {

    @Id
    public int code;

    public String name;

    public int currentMinPrice;

    public String icon;

    public int categoriesCode;

    public String grade;

    public ItemsDto(JSONObject object) {
        this.code = Integer.parseInt(object.get("Id").toString());
        this.name = object.get("Name").toString();
        this.currentMinPrice = Integer.parseInt(object.get("CurrentMinPrice").toString());
        this.icon = object.get("Icon").toString();
        this.categoriesCode = Integer.parseInt(object.get("categoryCode").toString());
        this.grade = object.get("Grade").toString();
    }

    public Items toEntity() {
        return Items.builder()
                .code(code)
                .name(name)
                .currentMinPrice(currentMinPrice)
                .icon(icon)
                .categoriesCode(categoriesCode)
                .grade(grade)
                .build();
    }
}
