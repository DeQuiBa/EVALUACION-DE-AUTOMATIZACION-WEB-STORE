package com.nttdata.steps;

import com.nttdata.core.DriverManager;
import com.nttdata.page.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;

public class StoreStepsValido {

    WebDriver driver;
    WebDriverWait wait;
    private int unidades;

    public void estoyEnLaPáginaDeLaTiendaConUnUsuarioYContraseñaVálidos() {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        System.out.println("Estoy en la página con usuario y contraseña");
        DriverManager.screenShot();
    }

    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {

        // Escribir usuario
        driver.findElement(LoginPage.TipoUsuario).sendKeys(usuario);
        // Escribir clave
        driver.findElement(LoginPage.TipoClave).sendKeys(clave);

        //esperar explicitas
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));

        //selecciono el boton
        driver.findElement(LoginPage.loginButton).click();
        System.out.println("Se presiono el boton para iniciar sesión");

        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.logoutText));
        String logoutText = driver.findElement(LoginPage.logoutText).getText();

        //hacemos la validación cuando aparezca el texto Cerrar sesión
        if(logoutText.equals("Cerrar sesión")){
            System.out.println("Validación correcta, textos iguales: " + logoutText);
            DriverManager.screenShot();
        } else {
            throw new AssertionError("Texto esperado: 'Cerrar Sesión' - Texto obtenido: '" + logoutText + "'");
        }
    }

    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        System.out.println("Me encuentro en la pagina principal de la store");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement categoriaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(NavigationPage.Categoria));
        String textoCategoria = categoriaElement.getText();
        System.out.println("Texto categoria obtenido de la pagina: " + textoCategoria);

        if(!textoCategoria.equalsIgnoreCase(categoria)) {
            DriverManager.screenShot();
            throw new AssertionError("Categoria incorrecta");
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(categoriaElement).perform();
        System.out.println("Estamos en el Hover en categoria: " + categoria);

        WebElement subcategoriaElement = wait.until(ExpectedConditions.elementToBeClickable(NavigationPage.SubCategoria));
        String textoSubcategoria = subcategoriaElement.getText();
        System.out.println("Texto subcategoria obtenido: " + textoSubcategoria);

        if(!textoSubcategoria.equalsIgnoreCase(subcategoria)) {
            DriverManager.screenShot();
            throw new AssertionError("Subcategoria incorrecta, esperada: ");
        }

        subcategoriaElement.click();
        System.out.println("Subcategoria seleccionada: " + subcategoria);
        DriverManager.screenShot();
    }

    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        this.unidades = unidades;
        System.out.println("Seleccionamos el primer producto que nos aparece");
        wait.until(ExpectedConditions.elementToBeClickable(FirstProduct.PrimerProducto)).click();


        WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstProduct.AgregarCantidad));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", campo);
        campo.sendKeys(String.valueOf(unidades));
        System.out.println("Agregamos la cantidad de unidades: " + unidades);

        System.out.println("Ahora Seleccionamos el boton");
        wait.until(ExpectedConditions.elementToBeClickable(FirstProduct.AgregarCarrito)).click();

        System.out.println("Validamos a través del texto que aparece en la ventana");
        DriverManager.screenShot();
    }

    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {

        //Validamos que si se pudo añadir las compras en el carrito
        WebElement elementoValidacion = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.TextoValidacion));
        String textoValidacion = elementoValidacion.getText();
        System.out.println("Texto obtenido: " + textoValidacion);

        //Eperamos capturar el texto de "Producto añadido correctamente a su carrito de compra"

        if(textoValidacion.contains("Producto añadido correctamente a su carrito de compra")) {
            System.out.println("Validación correcta: " + textoValidacion);
            DriverManager.screenShot();
        } else {
            throw new AssertionError("Texto esperado no encontrado");
        }
    }

    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        System.out.println("Vamos a calcular el monto Unitario por la catidad y luego comparar si es igual al Total");
        //Obtenemos la cantidad de unidades añadidas
        System.out.println("Unidades: " + unidades);

        //Hacamos la conversión respectiva para trabajar con números
        WebElement MontoUnitario = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.MontoPorUnidad));
        WebElement MontoTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.MontoTotal));

        double montoUnitario = Double.parseDouble(MontoUnitario.getText().replace("S/", "").trim());
        double montoTotal = Double.parseDouble(MontoTotal.getText().replace("S/", "").trim());
        double montoCalculado = montoUnitario * unidades;

        System.out.println("Monto unitario: " + montoUnitario);
        System.out.println("Monto calculado: " + montoCalculado);
        System.out.println("Monto total: " + montoTotal);

        if(montoCalculado == montoTotal){
            System.out.println("Monto total correcto, la cantidad es: " + montoTotal);
            DriverManager.screenShot();
        }else{
            throw new AssertionError("Valores incorrectos");
        }
    }

    public void finalizoLaCompra() {
        System.out.println("Seleccionamos el boton de finalizar compra del popup");
        wait.until(ExpectedConditions.elementToBeClickable(PopupPage.BotonFinalizarCompra)).click();
        DriverManager.screenShot();
    }

    public void validoElTituloDeLaPaginaDelCarrito() {
        WebElement elementoTitulo = wait.until(ExpectedConditions.visibilityOfElementLocated(CarPage.TituloDelCarrito));
        String tituloCarro = elementoTitulo.getText();
        System.out.println("Título obtenido: " + tituloCarro);

        if(tituloCarro.contains("CARRITO")){
            System.out.println("Se valida que el título: " + tituloCarro);
            DriverManager.screenShot();
        }else{
            throw new AssertionError("Titulo no encontrado");
        }
    }

    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        System.out.println("Obtenemos las unidades nuevamente para este proceso");

        //Hacamos la conversión respectiva para trabajar con números
        WebElement MontoUnitarioCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(CarPage.MontoObtenidoPorUnidadPaginaCarrito));
        WebElement MontoTotalCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(CarPage.MontoTotalObtenidoCarrito));

        double montoUnitarioCarrito = Double.parseDouble(MontoUnitarioCarrito.getText().replace("S/", "").trim());
        double montoTotalCarrito = Double.parseDouble(MontoTotalCarrito.getText().replace("S/", "").trim());
        double montoCalculadoCarrito = montoUnitarioCarrito * unidades;

        System.out.println("Monto unitario: " + montoUnitarioCarrito);
        System.out.println("Monto calculado: " + montoCalculadoCarrito);
        System.out.println("Monto total: " + montoTotalCarrito);

        if(montoCalculadoCarrito == montoTotalCarrito){
            System.out.println("Monto total correcto, la cantidad es: " + montoTotalCarrito);
        }else{
            throw new AssertionError("Valores incorrectos");
        }
        DriverManager.screenShot();
    }
}
