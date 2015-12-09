<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fieldset>
    <legend>
        Formulario Cliente
    </legend>
</fieldset>
<div class="form-group col-md-6 col-md-offset-2">   
    <s:form action="guardarOModificar" validate="true" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
        <%--<s:push value="candidato">--%>
        <s:hidden name="cliente.idCliente"/>
        <s:textfield name="cliente.nombre" label="Nombre" placeholder="Ingrese el nombre del cliente" />
        <s:textfield name="cliente.apellido" label="Apellido" placeholder="Ingrese el apellido del cliente" />
        <s:textfield name="cliente.telefonoUno" label="Telefono 1" placeholder="Ingrese el telefono del cliente" />
        <s:textfield name="cliente.telefonoDos" label="Telefono 2" placeholder="Ingrese el telefono del cliente" />
        <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-9 col-md-3"/>
        <%--</s:push>--%>            
    </s:form>
</div>