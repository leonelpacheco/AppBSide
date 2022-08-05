# AppBSide

Para el consumo de la API se realizaría con Retrofit.
Se crearía un object para su configuración
De acuerdo al request que requiera se crearían los modelos y con el apoyo de Gson se convertirían para su consumo
Se crea un repository para el llamado de retrofit por medio de suspend y corrutinas
en el ViewModel se hará referencia al repository para enviar los datos a la vista y mostrar la lista con el apoyo de un adapter
