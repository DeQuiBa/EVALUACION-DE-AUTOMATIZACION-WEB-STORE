package com.nttdata.page;

import org.openqa.selenium.By;

public class CarPage {
    public static By TituloDelCarrito = By.xpath("//div[@class='card-block']/h1[@class = 'h1']");
    public static By MontoObtenidoPorUnidadPaginaCarrito = By.xpath("//div[@class='current-price']/span[@class='price']");
    public static By MontoTotalObtenidoCarrito = By.xpath("//span[@class='product-price']");
}
