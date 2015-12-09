<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fieldset>
    <legend>
        Formulario Modelo
    </legend>
</fieldset>
<div class="form-group col-md-6 col-md-offset-2">   
    <s:form action="guardarOModificar" validate="true" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
        <%--<s:push value="candidato">--%>
        <s:hidden name="modelo.idModelo"/>
        <s:hidden name="modelo.marca.idMarca" id="idMarca"/>
        <div class="form-group">
            <label>Nombre</label>
            <s:textfield name="modelo.nombre" placeholder="Ingrese el nombre del modelo" />
        </div>
        <div class="form-group">
            <label>Marca</label>
            <div class="form-group">
                <div class="col-sm-9 controls">
                    <s:textfield class="form-control" type="text" name="modelo.marca.nombre" id="acMarca" placeholder="Ingrese la marca"/>
                </div>
            </div>  
        </div>

        <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-9 col-md-3"/>
        <%--</s:push>--%>            
    </s:form>
</div>