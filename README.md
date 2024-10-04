Conversor de Monedas
Este proyecto es un conversor de monedas simple que utiliza la API de ExchangeRate-API para obtener las tasas de cambio actualizadas y realizar conversiones entre dólares estadounidenses (USD) y otras monedas.

Funcionalidades
Convierte USD a ARS, BOB y BRL.

Convierte ARS, BOB y BRL a USD.

Obtiene las tasas de cambio actualizadas de la API de ExchangeRate-API.

Muestra un menú interactivo para seleccionar la opción de conversión.

Valida la entrada del usuario para asegurar que se ingresen números válidos.

Requisitos
Java 11 o superior

Gson library (incluida en el proyecto)

Una API key válida de ExchangeRate-API (se debe obtener por separado y agregar al archivo config.properties)

Configuración
Obtener una API key de ExchangeRate-API:

Visita el sitio web de ExchangeRate-API y crea una cuenta.

Obtén una API key gratuita o de pago.

Crear el archivo config.properties:

Crea un archivo llamado config.properties en la raíz del proyecto.

Agrega la siguiente línea al archivo, reemplazando TU_API_KEY con tu API key:

api.key=TU_API_KEY
Use code with caution.
Compilación y ejecución
Compilar:

javac Main.java ConversorDeMonedas.java
Use code with caution.
Bash
Ejecutar:

java Main
Use code with caution.
Bash
Uso
Al ejecutar el programa, se mostrará un menú con las opciones de conversión disponibles.

Selecciona la opción deseada ingresando el número correspondiente.

Ingresa la cantidad que deseas convertir cuando se te solicite.

El programa mostrará el resultado de la conversión.

Ejemplo
Seleccione la opción de conversión:
1. De USD a ARS
2. De ARS a USD
3. De USD a BOB
4. De BOB a USD
5. De USD a BRL
6. De BRL a USD
0. Salir
Opción: 1
Ingrese la cantidad en USD: 100
USD 100.00 es equivalente a 24567.89 ARS
Use code with caution.
Notas
El programa utiliza la API de ExchangeRate-API para obtener las tasas de cambio, por lo que se requiere una conexión a Internet para su funcionamiento.

Las tasas de cambio pueden variar con el tiempo, por lo que los resultados de las conversiones son aproximados.

El programa maneja algunos errores de entrada del usuario, pero no está exhaustivamente probado para todos los casos posibles.

Autor
Este proyecto fue creado por [Tu Nombre].
