package com.example.test.test2.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Items {

    @Id
    public int code;

    public String name;

    public int currentMinPrice;

    public String icon;

    public int categoriesCode;

    public String grade;
}
