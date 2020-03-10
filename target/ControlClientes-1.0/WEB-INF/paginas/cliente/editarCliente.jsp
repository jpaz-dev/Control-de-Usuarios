<!DOCTYPE html>
<html lang="ES">
    <head> 
        <!-- Required meta tags -->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" 
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
              crossorigin="anonymous"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet"/>
        <link rel="stylesheet" href="styles.css"/>
        <title>Editar de Clientes</title>
    </head>
    <body>
        <!-- Cabecero -->
        <jsp:include page="../comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}" 
              method="POST" class="was-validated mt-4">

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="display-4">EditarCliente</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" 
                                               name="nombre" required value="${cliente.nombre}"/>
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" 
                                               name="apellido" required value="${cliente.apellido}"/>
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control" 
                                               name="email" required value="${cliente.email}"/>
                                        <label for="telefono">Telefono</label>
                                        <input type="tel" class="form-control" 
                                               name="telefono" required value="${cliente.telefono}"/>
                                        <label for="saldo">Saldo</label>
                                        <input type="number" class="form-control" 
                                               name="saldo" required value="${cliente.saldo}" step="any"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- Botones de navegacion y edicion(para un form)-->
            <jsp:include page="../comunes/botonesNavegacionEdicion.jsp"/>
        </form>

        <!-- Pie de pagina -->
        <jsp:include page="../comunes/piePagina.jsp"/>

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" 
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" 
        crossorigin="anonymous"></script>
    </body>
</html>