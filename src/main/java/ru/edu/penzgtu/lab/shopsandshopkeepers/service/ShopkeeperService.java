package ru.edu.penzgtu.lab.shopsandshopkeepers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.shopsandshopkeepers.dto.ShopkeeperDto;
import ru.edu.penzgtu.lab.shopsandshopkeepers.entity.Shopkeeper;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.ErrorType;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.LabWorkException;
import ru.edu.penzgtu.lab.shopsandshopkeepers.repository.ShopkeeperRepository;
import ru.edu.penzgtu.lab.shopsandshopkeepers.service.mapper.ShopkeeperMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopkeeperService {
    private final ShopkeeperRepository shopkeeperRepo;
    private final ShopkeeperMapper shopkeeperMapper;

    public List<ShopkeeperDto> findAll() {
        return shopkeeperMapper.toListDto(shopkeeperRepo.findAll());
    }

    public ShopkeeperDto findById(Long id){
        Shopkeeper shopkeeper = shopkeeperRepo.findById(id)
                .orElseThrow(()-> new LabWorkException(ErrorType.NOT_FOUND, "Владелец с ID " + id + "не найден"));

        return shopkeeperMapper.toDto(shopkeeper);
    }

    public void createShopkeeper(ShopkeeperDto shopkeeperDto) {
        Shopkeeper shopkeeper = shopkeeperMapper.toEntity(shopkeeperDto);

        shopkeeperRepo.save(shopkeeper);
    }

    public void updateShopkeeper(Long id, ShopkeeperDto newShopkeeper){
        Shopkeeper oldShopkeeper = shopkeeperRepo.findById(id)
                .orElseThrow(()-> new LabWorkException(ErrorType.NOT_FOUND, "Владелец с ID " + id + "не найден"));

        oldShopkeeper.setName(newShopkeeper.getName());
        oldShopkeeper.setSurname(newShopkeeper.getSurname());
        oldShopkeeper.setShops(newShopkeeper.getShops());

        shopkeeperRepo.save(oldShopkeeper);
    }

    public void deleteShopkeeper(Long id) {
        shopkeeperRepo.deleteById(id);
    }
}
