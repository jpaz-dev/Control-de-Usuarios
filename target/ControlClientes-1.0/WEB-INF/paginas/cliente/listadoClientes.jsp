<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR" />

<section id="clientes" class="mt-3">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-9 mb-3">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Listado de Clientes</h4>
                            </div>
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Nombre</th>
                                        <th>Saldo</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${cliente.nombre} ${cliente.apellido}</td>
                                            <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
                                                   class="btn btn-secondary bottom">
                                                    <i class="material-icons">edit</i>editar
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <!-- Botones de navegacion -->
                        <jsp:include page="../comunes/botonesNavegacion.jsp"/>
                    </div>
                </div>
            </div>

            <!-- Tarjetas para totales -->
            <div class="col-md-3 col-sm-12">
                <div class="row">
                    <div class="col-sm-6 col-md-12">
                        <div class="card text-center bg-danger text-white mb-3">
                            <div class="card-header">
                                <h4>Saldo Total</h4>
                            </div>
                            <div class="card-body">
                                <h4>
                                    <fmt:formatNumber value="${saldoTotal}" type="currency" />
                                </h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-12">
                        <div class="card text-center bg-success text-white mb-3">
                            <div class="card-header">
                                <h4>Total Clientes</h4>
                            </div>
                            <div class="card-body">
                                <h4 class="display-4 bottom">
                                    <i class="material-icons md-56">group</i>${totalClientes}
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregar cliente MODAL -->
<jsp:include page="../cliente/agregarCliente.jsp" />