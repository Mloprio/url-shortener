# 🐱‍👤 Acortador de URLs



API REST que proporciona la posibilidad de convertir una URL larga a una URL acortada.

Al tomar la URL larga como entrada, se genera una key, empleando la función hash SHA-256. Esta key se encuentra mapeada con la URL
larga, y se utiliza para formar la URL acortada. De esta forma, si el usuario hace una petición usando la URL acortada, se usará un
código de redirección HTTP para realizar la búsqueda de la URL larga, mostrando el contenido de la página.

Este proyecto es parte de los Coding Challenges propuestos por John Crickett. Para más información acerca del objetivo del proyecto y del enunciado,
se puede consultar el siguiente [enlace](https://codingchallenges.fyi/challenges/challenge-url-shortener/).

## 💎 Tecnologías



- Spring Boot
- MyBatis
- PostgreSQL 
- Docker

## ✨ Funcionalidades



- ### Agregar una nueva URL larga, para generar su correspondiente key y formar la URL acortada.

    **POST**: `http://localhost:8080/newUrl`. El contenido del cuerpo tiene que ser un JSON con la estructura: `{"url": "https://google.com"}`.
    
    En caso de éxito, se devuelve la URL larga introducida, la key generada y la URL acortada.

- ### Obtener el contenido de la página de la URL larga, empleando la key generada.

    **GET**: `http://localhost:8080/{key}`.

    En caso exitoso, se redirecciona a la página de la URL larga introducida, mostrando su contenido.

- ### Eliminar la información asociada a una key.

    **DELETE**: `http://localhost:8080/{key}`.

    En caso de éxito, se elimina la URL larga, key y URL acortada (asociada a la key introducida).

## 🧪 ¿Qué he aprendido?



Durante la realización del proyecto he podido aprender nuevos conceptos, a la par que reforzar otros que ya conocía.

✔ **Pensamiento lógico para realizar las distintas funcionalidades**.

✔ **Conocer más acerca de las funciones hash**. Se ha tenido en cuenta cómo afecta la longitud de la clave y las posibles
colisiones que se pueden producir.

✔ **Practicar con Spring Boot**. Se ha seguido una organización del código por capas, lo que facilita el desarrollo, mantenimiento y la
modularidad.

✔ **Familiarización con MyBatis como framework de persistencia**.

## 🛠 Posibles pasos futuros



Algunos próximos pasos que se pueden agregar al proyecto son:

- Desarrollar una interfaz de usuario que emplee las funcionalidades de la API REST creada.
- Realizar un pipeline CI/CD para desplegar la aplicación en un proveedor Cloud.

## 🎮 Ejecutar la aplicación



1. Crear la base de datos. Personalmente, me resulta más cómodo usar Docker para ejecutar un contenedor en el que tener la BBDD
de PostgreSQL. El comando que he usado es:
`docker run --name postgresql -e POSTGRES_USER=<my_user> -e POSTGRES_PASSWORD=<my_pass> -e POSTGRES_DB=<database_name>
-p 5432:5432 -d postgres:15-bullseye`.

    Una vez que se descarga la imagen y el contenedor se está ejecutando, la base de datos se encuentra activa.
Para conectarse a ella de forma correcta, hay que modificar el archivo `application.properties`, cambiando `<database_port>`,
`<database_name>`, `<my_user>` y `<my_pass>` del código por el **puerto**, **nombre**, **usuario** y **contraseña** de la BBDD creada al ejecutar el
comando de Docker.

    En el resto del archivo application.properties no hay que modificar nada.

2. Una vez creada la base de datos, en el archivo `V1__initialization.sql` se tienen las queries SQL que hay que ejecutar
con lo necesario para la BBDD del proyecto. Se pueden ejecutar en un script, conectándose a la BBDD usando DBeaver (o cualquier otro sistema de gestión de
bases de datos).

3. Arrancar la aplicación de Spring Boot.