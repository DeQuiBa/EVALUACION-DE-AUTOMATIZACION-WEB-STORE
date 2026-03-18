package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    public static By TipoUsuario = By.id("field-email");
    public static By TipoClave = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By logoutText = By.xpath("//ul/li/a[@title='Cerrar sesión']");
}
