<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<div class="form-group">
    <s:actionmessage theme="bootstrap"/>
    <fieldset>
        <legend>
            Clientes
        </legend>
    </fieldset>  
    <div class=" col-md-12">
        <display:table name="clienteLista" pagesize="10" requestURI="${listar}" uid="row">
            <display:column property="idCliente" title="Id Cliente"/>
            <display:column property="nombre" title="Nombre"/>
            <display:column property="apellido" title="Apellido"/>
            <display:column property="telefonoUno" title="Telefono"/>
            <display:column property="telefonoDos" title="Telefono"/>
            <display:column title="Funciones">
                <s:form action="editar" id="editURL" style="display:inline-block;">
                    <s:hidden name="idCliente" value="%{#attr.row.idCliente}"/>
                    <s:submit value="Editar" action="%{editURL}" cssClass="btn btn-info"/>
                </s:form>
                <s:form action="eliminar" id="deleteURL" style="display:inline-block;">
                    <s:hidden name="idCliente" value="%{#attr.row.idCliente}"/>
                    <s:submit value="Eliminar" action="%{deleteURL}" cssClass="btn btn-danger"/>
                </s:form>
            </display:column>
        </display:table>

    </div>
</div>