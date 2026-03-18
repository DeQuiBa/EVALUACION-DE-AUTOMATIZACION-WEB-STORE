package com.nttdata.page;

import org.openqa.selenium.By;

public class FirstProduct {
    public static By PrimerProducto = By.xpath("//a[@class='thumbnail product-thumbnail']");
    public static By AgregarCantidad = By.xpath("//input[@name='qty']");
    public static By AgregarCarrito = By.xpath("//button[@class='btn btn-primary add-to-cart' and @type='submit']");
}
