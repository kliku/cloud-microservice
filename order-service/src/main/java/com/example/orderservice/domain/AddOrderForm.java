package com.example.orderservice.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class AddOrderForm {

    @NotNull
    private Long userId;
    @NotEmpty
    private List<Long> productsId;
}
