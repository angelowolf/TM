<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="form-group">
    <s:actionmessage theme="bootstrap"/>
    <fieldset>
        <legend>
            Ventas
        </legend>
    </fieldset>  
    <div class=" col-md-12">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Cliente
                    </th>    
                    <th>
                        Fecha
                    </th>
                    <th>
                        Bateria
                    </th>
                    <th>
                        Total
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="ventaLista">
                    <tr>
                        <td><s:property value="idVenta"/></td>
                        <td><s:property value="cliente.apellido"/> <s:property value="cliente.nombre"/></td>
                        <td><s:property value="fecha"/></td>
                        <td><s:property value="bateria.nombre"/></td>
                        <td><s:property value="total"/></td>
                        <td>
                            <s:form action="editar" id="editURL" style="display:inline-block;">
                                <s:hidden name="idVenta" value="%{idVenta}"/>
                                <s:submit value="Editar" action="%{editURL}" cssClass="btn btn-info"/>
                            </s:form>
                            <s:form action="eliminar" id="deleteURL" style="display:inline-block;">
                                <s:hidden name="idVenta" value="%{idVenta}"/>
                                <s:submit value="Eliminar" action="%{deleteURL}" cssClass="btn btn-danger"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>  
            </tbody>
        </table>
    </div>
</div>