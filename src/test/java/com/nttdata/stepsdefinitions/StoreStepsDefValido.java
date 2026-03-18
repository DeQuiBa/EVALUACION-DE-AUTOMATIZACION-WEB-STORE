package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreStepsValido;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreStepsDefValido {

    StoreStepsValido storeSteps;

    @Given("estoy en la página de la tienda Con un usuario y contraseña válidos")
    public void estoyEnLaPáginaDeLaTiendaConUnUsuarioYContraseñaVálidos() {
        storeSteps = new StoreStepsValido();
        storeSteps.estoyEnLaPáginaDeLaTiendaConUnUsuarioYContraseñaVálidos();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        storeSteps.meLogueoConMiUsuarioYClave(usuario, clave);

    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        storeSteps.navegoALaCategoriaYSubcategoria(categoria, subcategoria);
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        storeSteps.agregoUnidadesDelPrimerProductoAlCarrito(unidades);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        storeSteps.validoEnElPopupLaConfirmaciónDelProductoAgregado();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        storeSteps.validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        storeSteps.finalizoLaCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        storeSteps.validoElTituloDeLaPaginaDelCarrito();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        storeSteps.vuelvoAValidarElCalculoDePreciosEnElCarrito();
    }
}
