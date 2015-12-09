<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fieldset>
    <legend>
        Formulario Vehiculo
    </legend>
</fieldset>
<div class="form-group col-md-6 col-md-offset-2">   
    <s:form action="guardarOModificar" validate="true" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
        <%--<s:push value="candidato">--%>
        <s:hidden name="vehiculo.idVehiculo"/>
        <s:hidden name="idCliente" id="idCliente"/>
        <s:hidden name="idModelo" id="idModelo"/>

        <div class="form-group">
            <label>Cliente</label>
            <div class="form-group ">
                <div class="col-sm-9 controls">
                    <s:textfield class="form-control" type="text" name="vehiculo.cliente.nombreCompleto" id="acCliente" placeholder="Ingrese el cliente"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label>Modelo</label>
            <div class="form-group ">
                <div class="col-sm-9 controls">
                    <s:textfield class="form-control" type="text" name="vehiculo.modelo.nombreCompleto" id="acModelo" placeholder="Ingrese el cliente"/>
                </div>
            </div>
        </div>
        <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-9 col-md-3"/>
        <%--</s:push>--%>            
    </s:form>
</div>