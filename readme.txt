# ✅ PROYECTO: Reto Automatización – Devsu

**Autor:** Brayan Muñoz
**Lenguaje:** Java
**Java Version:** 11
**Gestor de dependencias:** Gradle

Este repositorio contiene la solución completa del reto técnico de automatización solicitado por **Devsu**, dividido en dos módulos:

- ✅ Automatización End-To-End (UI) con Serenity BDD + Screenplay
- ✅ Automatización de pruebas API con Karate DSL

---

# 🧪 1. AUTOMATIZACIÓN E2E – SauceDemo

## 📌 DESCRIPCIÓN GENERAL

Este módulo contiene una prueba funcional automatizada **End-To-End (E2E)**
sobre el flujo de compra de la aplicación **SauceDemo**.

La automatización cubre:

- ✅ Inicio de sesión
- ✅ Agregar productos al carrito *(dinámico)*
- ✅ Validación de productos seleccionados en el carrito
- ✅ Proceso de checkout
- ✅ Validación de mensaje de compra exitosa

El proyecto fue implementado utilizando el patrón **Screenplay con Serenity BDD**,
siguiendo una arquitectura por capas para mejorar la mantenibilidad y escalabilidad.

---

## 📂 ESTRUCTURA DEL MÓDULO E2E

```bash
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

▶️ EJECUCIÓN E2E
1. Ubicarse en la raíz del proyecto
  
2. Ejecutar pruebas
  gradlew :e2e-serenity:clean :e2e-serenity:test


⭐ DETALLES IMPORTANTES (E2E)

-La selección de productos es dinámica usando DataTables en Gherkin.
-No existe una limitación fija de cantidad de productos.
-Se realizan validaciones intermedias antes del checkout.
-La validación final confirma el mensaje de compra exitosa.
-Localizadores organizados en la capa UserInterfaces.


🌐 2. AUTOMATIZACIÓN API – Demoblaze (Karate)
📌 DESCRIPCIÓN GENERAL

Este módulo contiene pruebas automatizadas de API utilizando Karate DSL
sobre los endpoints de autenticación del sitio api.demoblaze.com.

Se desarrollaron 4 escenarios principales:

✅ Login exitoso
✅ Login con contraseña incorrecta
✅ Creación de usuario nuevo exitosamente
✅ Intento de creación de usuario ya existente

Las validaciones incluyen:
-Verificación de status code
-Validación del texto retornado en el response (plain text)
-Uso de datos reutilizables con Background
-Generación dinámica de usuarios para evitar conflictos

📂 ESTRUCTURA DEL MÓDULO API
api-karate
 ├── src/test/java
 │   └── runners
 │       └── KarateTestRunner.java
 │
 ├── src/test/resources
 │   ├── features
 │   │   ├── login.feature
 │   │   └── signup.feature
 │   │
 │   └── karate-config.js

▶️ EJECUCIÓN API
1. Ubicarse en la raíz del proyecto
  cd api-karate

2. Ejecutar pruebas
  gradlew :api-karate:test

⭐ DETALLES IMPORTANTES (API)
-Karate fue usado por su sintaxis simple y orientada a negocio.
-El sistema retorna respuestas en texto plano, por lo que no se utilizan asserts con JSON Schema.
-Para evitar errores de “usuario ya existe”, se genera un username dinámico
