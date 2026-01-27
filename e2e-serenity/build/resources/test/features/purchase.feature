Feature: Comprar productos en SauceDemo
  Yo como dueño del producto de SauceDemo
  Quiero tener una pasarela de compra
  Para los usuarios puedan agregar productos y comprarlos

  @smoke
  Scenario: Validar compra exitosa en SauceDemo
    Given Brayan inicia sesión en SauceDemo con usuario "standard_user" y contraseña "secret_sauce"
    When agrega productos al carrito
      | Sauce Labs Bike Light |
      | Sauce Labs Bolt T-Shirt |
    And completa el formulario de compra con nombre "Brayan" apellido "Munoz" y zip "893828"
    Then finaliza la compra y valida el mensaje "THANK YOU FOR YOUR ORsDER"
