package ru.edu.penzgtu.lab.shopsandshopkeepers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.lab.shopsandshopkeepers.dto.ShopDto;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.baseresponse.BaseResponseService;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.lab.shopsandshopkeepers.service.ShopService;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
@Tag(name = "Магазины", description = "Операции над магазинами")
public class ShopController {
    private final ShopService shopService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех магазинов", description = "Позволяет выгрузить все магазины из БД"
    )
    @GetMapping
    public ResponseWrapper<List<ShopDto>> findAll(){
        return baseResponseService.wrapSuccessResponse(shopService.findAll());
    }

    @Operation(
            summary = "Получение магазина по ID", description = "Позволяет выгрузить один магазин по ID из БД"
    )
    @GetMapping("/shop/{id}")
    public ResponseWrapper<ShopDto> findById(@PathVariable("id") @Min(0) Long id){
        return baseResponseService.wrapSuccessResponse(shopService.findById(id));
    }

    @Operation(
            summary = "Создать магазин", description = "Позволяет создать новую запись о магазине в БД"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createShop(@RequestBody @Valid ShopDto shop){
        shopService.createShop(shop);
    }

    @Operation(
            summary = "Обновить данные о магазине",
            description = "Позволяет обновить информацию о магазине в БД"
    )
    @PutMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShop(
            @PathVariable("id") @Min(0) Long id,
            @RequestBody @Valid ShopDto shop) {
        shopService.updateShop(id,shop);
    }

    @Operation(
            summary = "Удалить магазин по ID", description = "Позволяет удалить запись о магазине по ID в БД"
    )
    @DeleteMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@PathVariable("id") @Min(0) Long id){
        shopService.deleteShop(id);
    }
}
