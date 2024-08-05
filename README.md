# KarateFramework
Ejercicio de automatización de pruerbas APIS
##Descipción

Prueba funcional automatizada (Prueba E2E) de un flujo de compra en la página URL: https://www.demoblaze.com/
• Crear un nuevo usuario en signup
• Intentar crear un usuario ya existente
• Usuario y password correcto en login
• Usuario y password incorrecto en login

##Prerequisitos
- Para configurar y ejecutar este proyecto en tu máquina local, asegúrese de tener las siguientes versiones de dependencias y tecnologías:
- Sistema operativo: Windows 10-11
- IDE: IntelliJ IDEA versión 2024.1.4
- JDK: versión 17.0.12 (asegúrate de que esté en la variable de entorno)
- Gradle: versión 8.5 (asegúrate de que esté en la variable de entorno)

##2. Comandos de instalación
- Clonar el repositorio: 
  - git clone https://github.com/Sussexmel/KarateFramework.git
 
##3. Instrucciones para ejecutar los test
- Abra una terminal en la raíz del proyecto y ejecute: el siguiente comando:
  - ./gradlew clean test
- Si está en Windows y "gradlew" no es reconocido, pruebe con:
  - gradlew.bat clean test
- Generar el reporte de Cucumber:
  - ./gradlew cucumberReport
 
##4. Información adicional
- Para Cucumber con Serenity BDD: Usar LoginTest para ejecutar las pruebas y genera reportes en target/site/serenity.
- Para Karate: Usar ApiTest para ejecutar las pruebas y genera reportes en build/reports/tests/test

##Referencia:
- Repositorio en Github: https://github.com/Sussexmel/KarateFramework.git
