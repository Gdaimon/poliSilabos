Quedó solucionado el tema del modelo entidad relación, se realizaron los siguientes ajustes:

VER CAMBIOS EN "3.Create Tables PoliSilabo.sql"

1.La tabla par_titulos se eliminó dado que hace referencia al titulo del núcleo tematico, en su contraparte se cambió el nombre de la columna par_nucleo_tematico(descripcion) por par_nucleo_tematico(nombre), esta columna hace referencia a lo que "hacía" part_titulos.

2. Se creó la tabla muchos a muchos par_nucleo_eje, esta tabla relaciona los nucleos con sus respectivos ejes.

3. Se creó la tabla muchos a muchos par_nucleo_onjectivo, esta tabla relaciona los nucleos con sus respectivos onjectivos.

4. Se creó la tabla par_silabo la cual contendrá toda la información de un silabo

5. Se creó la tabla muchos a muchos par_silabo_nucleo, esta tabla relaciona los silabos con sus respectivos núcleos temáticos.

6. Se creó la tabla muchos a muchos par_silabo_competencia, esta tabla relaciona los silabos con sus respectivas competencias.

7. Se creó copia en la carpeta OLD del "ANEXO - Base de Datos\MODELO ACTUAL"
