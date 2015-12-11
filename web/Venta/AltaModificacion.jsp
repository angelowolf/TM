<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fieldset>  
    <s:fielderror theme="bootstrap"/>
    <legend>
        Formulario Venta
    </legend>
</fieldset>
<div class="form-group col-md-6 col-md-offset-2">   
    <s:form action="guardarOModificar" validate="true" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
        <%--<s:push value="candidato">--%>
        <s:hidden name="venta.idVenta"/>
        <s:hidden name="idCliente" id="idCliente"/>
        <s:hidden name="idBateria" id="idBateria"/>

        <div class="form-group">
            <label>Bateria</label>
            <div class="form-group">
                <div class="col-sm-9 controls">
                    <s:textfield class="form-control" type="text" name="venta.bateria.nombre" id="acBateria" placeholder="Ingrese la bateria"/>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <label>Cantidad</label>
            <div class="form-group">
                <div class="col-sm-3 controls">
                    <s:textfield name="venta.cantidad" placeholder="Ingrese la cantidad"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label>Fecha</label> 
            <div class='input-group date' id='fecha'>
                <s:textfield type='text' id="fecha" name="venta.fecha" />
            </div>
        </div>
        <div class="form-group">
            <label>Cliente</label>
            <div class="form-group ">
                <div class="col-sm-9 controls">
                    <s:textfield class="form-control" type="text" name="venta.cliente.nombreCompleto" id="acCliente" placeholder="Ingrese el cliente"/>
                </div>
            </div>
        </div>    
    <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-6 col-md-2"/>
    <%--</s:push>--%>            
</s:form>
</div>