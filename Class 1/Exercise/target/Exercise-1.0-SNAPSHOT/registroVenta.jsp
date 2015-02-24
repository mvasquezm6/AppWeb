<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro Venta</h1>
        <a href="ListarCanasta">Ver Canasta</a>
        <form method="POST" action="AgregarItem">
            Articulo: <input type="text" name="articulo"/><br>
            Precio: <input type="text" name="precio"/><br>
            Cantidad: <input type="text" name="cantidad"/><br>
            <input type="submit" value="Registrar"/>
        </form>
    </body>
</html>
