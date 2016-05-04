#PoliSílabo
>Conexión Base de Datos
>-------------
1. Ir a la pestaña Prestaciones (Services) en NetBeans  
2. Seleccionar Icono Base de Datos  
3. Click derecho sobre el Icono y Seleccionar Nueva conexión a base de datos
4. Damos Click en Driver y seleccionamos PostgreSql
5. Damos click en **Siguiente**...
6. Ingresamos el Nombre de la Base de datos en mi caso 'polisilabo'
7. Ingresamos el Nombre de Usuario en mi caso 'polisilabo'
8. Ingresamos la contraseña de la base de datos en mi caso 'polisilabo'
9. Realizamos la prueba de la base de datos dando click en **Probar Conexión** nos debara indicar *Connection Succeeded*
10. Si nos salio el mensaje *Connection Succeeded* podemos dar click en **Siguiente**...
11. Seleccionamos el schema a utilizar, en mi caso 'public'
12. **Siguiente**...
13. **Terminar**... y listo ya se efectuo la conexión a la base de datos
14. Configurar el Archivo persistence.xml (Este Archivo ya fue modificado, pero si presentan inconvenientes con el Deploy) hacer lo siguiente:  
Ir a Configuration File ==> persistence.xml y en Fuente de datos agregar el nombre de la base de datos (polisilabo)

##Stack Utilizado
* BackboneJs
* UnderscoreJs
* PostgreSql
* Java (API - REST)
* NeatBeans (GlashFish)
* Bootstrap
