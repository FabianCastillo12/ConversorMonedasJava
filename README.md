# Conversor de Monedas

Este proyecto es un conversor de monedas simple que utiliza la API de ExchangeRate-API para obtener las tasas de cambio actualizadas y realizar conversiones entre dólares estadounidenses (USD) y otras monedas.

## Funcionalidades

* **Conversiones:**
    * Convierte USD a ARS, BOB y BRL.
    * Convierte ARS, BOB y BRL a USD.
* **API de ExchangeRate-API:** Obtiene las tasas de cambio actualizadas.
* **Menú interactivo:** Muestra un menú para seleccionar la opción de conversión.

## Requisitos

* **Java:** Versión 11 o superior.
* **Gson library:** Incluida en el proyecto.
* **API key de ExchangeRate-API:** Se debe obtener por separado y agregar al archivo `config.properties`.

## Configuración

1. **Obtener una API key de ExchangeRate-API:**

2. **Crear el archivo `config.properties`:**
   - Crea un archivo llamado `config.properties` en la raíz del proyecto.
   - Agrega la siguiente línea al archivo, reemplazando `TU_API_KEY` con tu API key:

     ```
     api.key = TU_API_KEY
     ```

## **Uso**
* Al ejecutar el programa, se mostrará un menú con las opciones de conversión disponibles.

* Selecciona la opción deseada ingresando el número correspondiente.

* Ingresa la cantidad que deseas convertir cuando se te solicite.

* El programa mostrará el resultado de la conversión.

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
    

## **Autor**
Este proyecto fue creado por Fabian Castillo Vega.

