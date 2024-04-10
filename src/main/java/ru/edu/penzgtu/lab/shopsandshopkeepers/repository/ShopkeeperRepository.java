package ru.edu.penzgtu.lab.shopsandshopkeepers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.penzgtu.lab.shopsandshopkeepers.entity.Shopkeeper;

@Repository
public interface ShopkeeperRepository extends JpaRepository<Shopkeeper, Long> {
}
