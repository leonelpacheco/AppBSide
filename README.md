# AppBSide
Para la edición del Contacto se crea la estructura correspondiente para el update con Room, se reutiliza la vista de insertar.
En el adapter se agregaría un elemento para mostrar si es o no favorito y se agregaría igual en el objeto para que se pueda asignar al crear o editar el contacto

Para el consumo de la API se realizaría con Retrofit.
Se crearía un object para su configuración
De acuerdo al request que requiera se crearían los modelos y con el apoyo de Gson se convertirían para su consumo
Se crea un repository para el llamado de retrofit por medio de suspend y corrutinas
en el ViewModel se hará referencia al repository para enviar los datos a la vista y mostrar la lista con el apoyo de un adapter
