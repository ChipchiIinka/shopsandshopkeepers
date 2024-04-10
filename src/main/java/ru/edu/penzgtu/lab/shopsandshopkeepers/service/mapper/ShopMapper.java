package ru.edu.penzgtu.lab.shopsandshopkeepers.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.shopsandshopkeepers.dto.ShopDto;
import ru.edu.penzgtu.lab.shopsandshopkeepers.entity.Shop;

import java.util.List;

@Service
public class ShopMapper {
    public List<ShopDto> toListDto(List<Shop> shops){
        return shops.stream().map(this::toDto).toList();
    }

    public ShopDto toDto(Shop shop){
        return ShopDto.builder()
                .id(shop.getId())
                .title(shop.getTitle())
                .description(shop.getDescription())
                .location(shop.getLocation())
                .dateOfCreation(shop.getDateOfCreation())
                .shopkeepers(shop.getShopkeepers().stream()
                        .toList())
                .build();
    }

    public Shop toEntity(ShopDto shopDto){
        Shop shop = new Shop();

        shop.setTitle(shopDto.getTitle());
        shop.setDescription(shopDto.getDescription());
        shop.setLocation(shopDto.getLocation());
        shop.setDateOfCreation(shopDto.getDateOfCreation());
        shop.setShopkeepers(shopDto.getShopkeepers().stream().toList());

        return shop;
    }
}
