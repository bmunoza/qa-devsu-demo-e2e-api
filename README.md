# SauceDemo E2E Automation -Devsu

Automatización End-to-End (E2E) del flujo de compra en SauceDemo, implementada con Serenity BDD, Screenplay Pattern y Cucumber, siguiendo buenas prácticas de diseño, mantenibilidad y escalabilidad.

---

## Tecnologías utilizadas

- Lenguaje: Java  
- Framework E2E: Serenity BDD  
- Patrón de diseño: Screenplay  
- BDD: Cucumber  
- Gestor de dependencias: Gradle  
- Navegador: Google Chrome  
- Versión de Java: JDK 11  

---

## Alcance de la automatización

La automatización cubre el siguiente flujo funcional:

1. Inicio de sesión en SauceDemo  
2. Agregar productos al carrito (dinámico)  
3. Validación intermedia de los productos en el carrito  
4. Proceso de checkout  
5. Validación de compra exitosa  

---

## Enfoque de diseño

- Uso de Screenplay Pattern para desacoplar responsabilidades  
- Separación por capas (Tasks, Questions, UserInterfaces)  
- Escenarios reutilizables y escalables  
- Validaciones intermedias y finales  
- Datos controlados desde el feature (BDD)  

---

## Estructura del proyecto
e2e-serenity
├── questions
│   ├── CartProductNames
│   └── ConfirmationMessage
│
├── runners
│   └── PurchaseRunner
│
├── stepDefinitions
│   ├── Hooks
│   └── PurchaseStepDefinitions
│
├── tasks
│   ├── Login
│   ├── AddProducts
│   ├── VerifyCart
│   └── Checkout
│
├── userInterfaces
│   ├── LoginPage
│   ├── InventoryPage
│   └── CheckoutPage
│
├── resources
│   ├── features
│   │   └── purchase.feature
│   └── serenity.conf


--------------------------------------------------
PASOS PARA EJECUTAR EL PROYECTO
--------------------------------------------------
1. Tener instalado:
   - Java JDK 11
   - Gradle
   - Google Chrome

2. Clonar el repositorio:
   git clone https://github.com/bmunoza/qa-devsu-demo-e2e-api.git

3. Ubicarse en la carpeta del proyecto:
   cd e2e-serenity

4. Ejecutar las pruebas:
   gradlew clean test

5. Generar el reporte Serenity:
   gradlew aggregate

6. Abrir el reporte:
   e2e-serenity/target/site/serenity/index.html

--------------------------------------------------
DETALLES IMPORTANTES
--------------------------------------------------
- La selección de productos se maneja de forma dinámica usando DataTables en el feature.
- No existe una limitación fija de cantidad de productos.
- Las validaciones intermedias se realizan antes del checkout.
- La validación final confirma el mensaje de compra exitosa.
- Los localizadores están desacoplados en la capa UserInterfaces.

