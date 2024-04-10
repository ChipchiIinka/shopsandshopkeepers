package ru.edu.penzgtu.lab.shopsandshopkeepers.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.shopsandshopkeepers.dto.ShopkeeperDto;
import ru.edu.penzgtu.lab.shopsandshopkeepers.entity.Shopkeeper;

import java.util.List;

@Service
public class ShopkeeperMapper {
    public List<ShopkeeperDto> toListDto(List<Shopkeeper> shopkeepers){
        return shopkeepers.stream().map(this::toDto).toList();
    }

    public ShopkeeperDto toDto(Shopkeeper shopkeeper){
        return ShopkeeperDto.builder()
                .id(shopkeeper.getId())
                .name(shopkeeper.getName())
                .surname(shopkeeper.getSurname())
                .shops(shopkeeper.getShops().stream()
                        .toList())
                .build();
    }

    public Shopkeeper toEntity(ShopkeeperDto shopkeeperDto){
        Shopkeeper shopkeeper = new Shopkeeper();

        shopkeeper.setName(shopkeeperDto.getName());
        shopkeeper.setSurname(shopkeeperDto.getSurname());
        shopkeeper.setShops(shopkeeperDto.getShops().stream().toList());

        return shopkeeper;
    }
}
