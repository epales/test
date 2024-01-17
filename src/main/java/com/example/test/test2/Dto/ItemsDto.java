package com.example.test.test2.Dto;

import org.json.simple.JSONObject;

import com.example.test.test2.Domain.Items;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ItemsDto {
    
    public int code;

    @Id
    public String name;

    public int currentMinPrice;

    public ItemsDto(JSONObject object){
        this.code = Integer.parseInt(object.get("Id").toString());
        this.name = object.get("Name").toString();
        this.currentMinPrice = Integer.parseInt(object.get("CurrentMinPrice").toString());
    }
    public Items toEntity() {
		return Items.builder()
			.code(code)
			.name(name)
            .currentMinPrice(currentMinPrice)
			.build();
	}
}
