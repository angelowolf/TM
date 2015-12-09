<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fieldset>
    <legend>
        Formulario Bateria
    </legend>
</fieldset>
<div class="form-group col-md-6 col-md-offset-2">   
    <s:form action="guardarOModificar" validate="true" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
        <%--<s:push value="candidato">--%>
        <s:hidden name="bateria.idBateria"/>
        <s:textfield name="bateria.nombre" value="%{bateria.nombre}" label="Nombre" placeholder="Ingrese el nombre de la bateria" />
        <s:textfield name="bateria.precio" value="%{bateria.precio}" label="Precio" placeholder="Ingrese el precio de la bateria" />
        <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-9 col-md-3"/>
        <%--</s:push>--%>            
    </s:form>
</div>