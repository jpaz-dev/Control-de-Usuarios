<section id="actions" class="py-4 mt-4 bg-light">
    <div class="container">
        <div class="row center d-flex justify-content-around">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-secondary btn-block bottom">
                    <i class="material-icons md-24">arrow_back</i>Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block bottom">
                    <i class="material-icons md-24">done</i>Guardar Cliente
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}" 
                   class="btn btn-danger btn-block bottom">
                    <i class="material-icons md-24">delete</i>Eliminar Cliente
                </a>
            </div>
        </div>
    </div>
</section>