<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio 1</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        
        <script>
            /*DOM */
            $(document).ready(function(){
                $('#submit').click(function(event){
                    var nombreVar=$('#nombre').val();
                    var apellidoVar=$('#apellido').val();
                    var edadVar=$('#edad').val();                    
                    $.post('/Exercise/ServletEjercicio1',{
                        nombre:nombreVar,
                        apellido:apellidoVar,
                        edad:edadVar,
                    },function(responseText){
                       $('#tabla').html(responseText);
                    });                    
                });
            });            
        </script>
    </head>
    <body>
        <h2>Ejercicio Servlets - (Petición - Respuesta)</h2>
        <form id="form1">
            Nombre:<input type="text" id="nombre" /><br>
            Apellido:<input type="text" id="apellido" /><br>
            Edad:<input type="text" id="edad" /><br>
            <input type="button" id="submit" value="Registrar"/>
        </form>
        <br>
        
        <div id="tabla"></div>
    </body>
</html>
