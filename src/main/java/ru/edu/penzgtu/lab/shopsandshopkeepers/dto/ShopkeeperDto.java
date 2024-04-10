package ru.edu.penzgtu.lab.shopsandshopkeepers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import ru.edu.penzgtu.lab.shopsandshopkeepers.entity.Shop;
import java.util.List;

@Data
@Builder
@Schema(description = "Информация о владельце")
public class ShopkeeperDto {
    @JsonProperty("id")
    @Schema(description = "Id владельца в БД", example = "1")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Имя владельца магазина", example = "Олег")
    private String name;

    @JsonProperty("surname")
    @NotBlank
    @Schema(description = "Фамилия владельца магазина", example = "Темнов")
    private String surname;

    @JsonProperty("shops")
    @Schema(description = "Магазины владельца")
    private List<Shop> shops;
}
