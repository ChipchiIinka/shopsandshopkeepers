package ru.edu.penzgtu.lab.shopsandshopkeepers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.shopsandshopkeepers.dto.ShopDto;
import ru.edu.penzgtu.lab.shopsandshopkeepers.entity.Shop;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.ErrorType;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.LabWorkException;
import ru.edu.penzgtu.lab.shopsandshopkeepers.repository.ShopRepository;
import ru.edu.penzgtu.lab.shopsandshopkeepers.service.mapper.ShopMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepo;
    private final ShopMapper shopMapper;

    public List<ShopDto> findAll(){
        return shopMapper.toListDto(shopRepo.findAll());
    }

    public ShopDto findById(Long id){
        Shop shop = shopRepo.findById(id)
                .orElseThrow(()-> new LabWorkException(ErrorType.NOT_FOUND, "Магазин  с ID " + id + " не найден."));
        return shopMapper.toDto(shop);
    }

    public void createShop(ShopDto shopDto){
        Shop shop = shopMapper.toEntity(shopDto);

        shopRepo.save(shop);
    }

    public void updateShop(Long id, ShopDto newShop){
        Shop oldShop = shopRepo.findById(id)
                .orElseThrow(()-> new LabWorkException(ErrorType.NOT_FOUND, "Магазин  с ID " + id + "не найден"));
        oldShop.setTitle(newShop.getTitle());
        oldShop.setDescription(newShop.getDescription());
        oldShop.setLocation(newShop.getLocation());
        oldShop.setDateOfCreation(newShop.getDateOfCreation());
        oldShop.setShopkeepers(newShop.getShopkeepers());
        shopRepo.save(oldShop);
    }

    public void deleteShop(Long id){
        shopRepo.deleteById(id);
    }
}
