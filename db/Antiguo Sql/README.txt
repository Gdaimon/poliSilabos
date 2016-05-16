Quedó solucionado el tema del modelo entidad relación, se realizaron los siguientes ajustes:

VER CAMBIOS EN "3.Create Tables PoliSilabo.sql"

1.La tabla par_titulos se eliminó dado que hace referencia al titulo del núcleo tematico, en su contraparte se cambió el nombre de la columna par_nucleo_tematico(descripcion) por par_nucleo_tematico(nombre), esta columna hace referencia a lo que "hacía" part_titulos.

2. Se creo la tabla muchos a muchos par_nucleo_eje, esta tabla relaciona los nucleos con sus respectivos ejes.

3.  Se creo la tabla muchos a muchos par_nucleo_onjectivo, esta tabla relaciona los nucleos con sus respectivos onjectivos.

4. Se creó copia en la carpeta OLD del "ANEXO - Base de Datos\MODELO ACTUAL"
