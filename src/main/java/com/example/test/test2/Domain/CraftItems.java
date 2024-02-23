package com.example.test.test2.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
public class CraftItems {

    @Id
    public int code;

    public String name;

    public int craftCode;
}
