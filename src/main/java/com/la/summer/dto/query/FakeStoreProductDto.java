package com.la.summer.dto.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {

    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;

}
