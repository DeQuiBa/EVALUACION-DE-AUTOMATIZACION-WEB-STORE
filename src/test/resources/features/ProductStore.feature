
  Feature: Product - Store
  @UsuarioValido
   Scenario: : Validación del precio de un producto
     Given estoy en la página de la tienda Con un usuario y contraseña válidos
     And me logueo con mi usuario "deivis291203@gmail.com" y clave "Sheltondeivis1@1"
     When navego a la categoria "Clothes" y subcategoria "Men"
     And agrego 2 unidades del primer producto al carrito
     Then valido en el popup la confirmación del producto agregado
     And valido en el popup que el monto total sea calculado correctamente
     When finalizo la compra
     Then valido el titulo de la pagina del carrito
     And vuelvo a validar el calculo de precios en el carrito

  @UsuariInvalido
  Scenario: : Validación del precio de un producto
    Given estoy en la página de la tienda Con un usuario y contraseña válidos
    And me logueo con mi usuario "bart3@gmail.com" y clave "FASDerers1@1"
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

  @CategoriaInvalida
  Scenario: : Validación del precio de un producto
    Given estoy en la página de la tienda Con un usuario y contraseña válidos
    And me logueo con mi usuario "deivis291203@gmail.com" y clave "Sheltondeivis1@1"
    When navego a la categoria "Autos" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito





# @EscenariosCompletos
# Scenario Outline: Validación del precio de un producto
#   Given estoy en la página de la tienda Con un usuario y contraseña válidos
#   And me logueo con mi usuario "<usuario>" y clave "<clave>"
#   When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
#   And agrego 2 unidades del primer producto al carrito
#   Then valido en el popup la confirmación del producto agregado
#   And valido en el popup que el monto total sea calculado correctamente
#   When finalizo la compra
#   Then valido el titulo de la pagina del carrito
#   And vuelvo a validar el calculo de precios en el carrito
#   Examples:
#     | usuario                   | clave             | categoria | subcategoria |
#     | deivis291203@gmail.com    | Sheltondeivis1@1  | Clothes   | Men          |
#     | Bartitoasdf@gmail.com     | EstBar123         |           |         |
#     | deivis291203@gmail.com    | Sheltondeivis1@1  | Autos     | Men          |
#



