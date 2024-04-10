package ru.edu.penzgtu.lab.shopsandshopkeepers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.lab.shopsandshopkeepers.dto.ShopkeeperDto;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.baseresponse.BaseResponseService;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.lab.shopsandshopkeepers.service.ShopkeeperService;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/shopkeepers")
@Tag(name = "Владельцы магазинов", description = "Операции над владельцами")
public class ShopkeeperController {
    private final ShopkeeperService shopkeeperService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех владельцев", description = "Позволяет выгрузить всех владельцев из БД"
    )
    @GetMapping
    public ResponseWrapper<List<ShopkeeperDto>> findAll(){
        return baseResponseService.wrapSuccessResponse(shopkeeperService.findAll());
    }

    @Operation(
            summary = "Получение владельца по ID", description = "Позволяет выгрузить одного владельца по ID из БД"
    )
    @GetMapping("/shopkeeper/{id}")
    public ResponseWrapper<ShopkeeperDto> findById(@PathVariable("id") @Min(0) Long id){
        return baseResponseService.wrapSuccessResponse(shopkeeperService.findById(id));
    }

    @Operation(
            summary = "Создать владельца", description = "Позволяет создать новую запись о владельце в БД"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createShopkeeper(@RequestBody @Valid ShopkeeperDto shopkeeper){
        shopkeeperService.createShopkeeper(shopkeeper);
    }

    @Operation(
            summary = "Обновить данные о владельце по ID",
            description = "Позволяет обновить информацию о владельце по ID в БД"
    )
    @PutMapping("/shopkeeper/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShopkeeper(
            @PathVariable("id") @Min(0) Long id,
            @RequestBody @Valid ShopkeeperDto shopkeeper) {
        shopkeeperService.updateShopkeeper(id,shopkeeper);
    }

    @Operation(
            summary = "Удалить владельца по ID", description = "Позволяет удалить запись о владельце по ID в БД"
    )
    @DeleteMapping("/shopkeeper/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShopkeeper(@PathVariable("id") @Min(0) Long id){
        shopkeeperService.deleteShopkeeper(id);
    }
}
