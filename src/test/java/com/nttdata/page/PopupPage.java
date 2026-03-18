package com.nttdata.page;

import org.openqa.selenium.By;

public class PopupPage {
    public static By TextoValidacion = By.id("myModalLabel");
    public static By MontoPorUnidad = By.xpath("//div[@class='col-md-6']/p[@class=\"product-price\"]");
    public static By MontoTotal = By.xpath("//div/p[@class='product-total']/span[@class='value']");
    public static By BotonFinalizarCompra = By.xpath("//div[@class=\"cart-content-btn\"]/a[@class=\"btn btn-primary\"]");
}
