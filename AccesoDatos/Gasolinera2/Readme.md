# Gasolinera

### Estructura proyecto

```
Gasolinera2
- datos                             -> Carpeta datos en formato CSV
    - clientes.csv                      -> Datos de cliente
    - pagos.csv                         -> Datos de pagos
- datosJSON                         -> Carpeta datos en formato JSON
    - clientes.json                     -> Datos de cliente
    - pagos.json                        -> Datos de pagos
- src                               -> Clases e interfaces de proyecto
    - Clientes.java                     -> Clientes de la gasolinera
    - GestionClientes.java              -> Creación, listado y busqueda de clientes
    - GestionFicherosCSV.java           -> Creación y listado de objetos en ficheros CSV
    - GestionFicherosJSON.java          -> Creación y listado de objetos en ficheros JSON
    - GestionPagos.java                 -> Creación y listado de pagos sobre clientes de gasolinera
    - InterfazFicheros.java             -> Interfaz de clases que gestionan ficheros para la gasolinera.
    - Main.java                         -> Empiece del programa
    - Menu.java                         -> Muestra menu y gestiona programa
    - MigrarCSVToJson.java              -> Migrar de ficheros CSV a JSON
    - PagosRepostaje.java               -> Pagos de la gasolinera
- Cambios.md                        -> Fichero informativo de cambios de Gasolinera1 a Gasolinera2 
- Readme.md                         -> Este fichero.
```

### Pasos ejecución de programa

1. Clonar este repositorio
    ```git clone https://github.com/languita29/LuisBrailleDAM2.git```
2. En IDE como inteliJ abrir el proyecto
    ``LuisBrailleDAM2\AccesoDatos\Gasolinera2``
3.  Ejecutar el proyecto.

### Flujo de proyecto
1. Si no tienes ficheros JSON te va a dar la opción de inicializar una migración.
2. Al seleccionar no, sigue con el menú normal, si dices que si te pedirá el directorio y ficheros de datos csv.
3. Si encuentra los ficheros CSV iniciará la migración dando como resultado una carpeta JSON con ficheros de datos .json.
4. Independientemente de lo que elijas en los pasos anteriores te va a salir el menú de usuario. 
5. Si quieres crear un cliente selecciona la opción 1, que te pedirá todos los datos necesarios, si no existe cliente con esa matrícula te lo crará en el fichero clientes.json sino volverá al menú. Se le asignará un id por defecto que recopila en el momento del último id de fichero clientes.json.
6. Si quieres listar clientes selecciona la opción 2, si está vacía te lo indicará.
7. Si quieres buscar un cliente por una palabra selecciona la opción 3.
8. Si quieres crear un pago selecciona la opción 4, tiene que haber clientes creados y tiene que ser sobre un cliente ya existente, al dejar la fecha vacía se asumirá la fecha de hoy.
9. Si queieres listar los pagos, selecciona la opción 5, te indicará si no hay pagos creado.
10. Para salir selecciona la opción 0, si seleccionas cualquier otra opción te volverá a pedir número.

## Proceso de guardado
- Todos los clientes y pagos se crean y guardan en los ficheros correspondientes en el momento.
- La lectura de clientes y pagos se hace sobre los ficheros correspondientes.
- Cuando se guardan clientes y pagos se sobreescribe lo que había en el fichero recuperando lo que había para mantener el principio y final del fichero.





