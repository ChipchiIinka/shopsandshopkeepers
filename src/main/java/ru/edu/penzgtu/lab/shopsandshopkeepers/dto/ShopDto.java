package ru.edu.penzgtu.lab.shopsandshopkeepers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import ru.edu.penzgtu.lab.shopsandshopkeepers.entity.Shopkeeper;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Schema(description = "Информация о магазине")
public class ShopDto {
    @JsonProperty("id")
    @Schema(description = "Id магазина в БД", example = "1")
    private Long id;

    @JsonProperty("title")
    @NotBlank
    @Schema(description = "Название магазина", example = "Магнит")
    private String title;

    @JsonProperty("description")
    @NotBlank
    @Schema(description = "Описание магазина", example = "Это хороший магазин")
    private String description;

    @JsonProperty("location")
    @NotBlank
    @Schema(description = "Местоположение магазина", example = "г. Пенза, ул. Ушакова, 12")
    private String location;

    @JsonProperty("date_of_creation")
    @Schema(description = "Дата основания магазина", example = "1999.12.31")
    private Date dateOfCreation;

    @JsonProperty("shopkeepers")
    @Schema(description = "Владельцы магазина")
    private List<Shopkeeper> shopkeepers;
}
