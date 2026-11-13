### Cambios de Gasolinera1 a Gasolinera2

#### Gasolinera1

- Formato de guardado CSV
- Clientes y pagos se recuperan al principio de sus ficheros y se guardan en una lista.
- Clientes y pagos se escriben en sus ficheros al final del todo.

#### Gasolinera2

- Formato de guardado JSON
- Clientes y pagos se recupera en el momento de necesitarlo del fichero correspondiente, si se lista, se comprueba existencias ...
- Clientes y pagos se escriben en sus ficheros en el momento de dar de alta alguno de los dos.
- Clase MigrarCSVToJSON para cambiar los datos de ficheros CSV a ficheros JSON.
