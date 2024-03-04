package com.example.test.test2.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class CraftItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int seq;
    // 제작 아이템, 제작에 필요한 아이템, 제작 갯수

    public int code;

    public int craftCode;

    public int number;
}
