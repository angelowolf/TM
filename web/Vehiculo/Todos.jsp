<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="form-group">
    <s:actionmessage theme="bootstrap"/>
    <fieldset>
        <legend>
            Vehiculos
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
                        Marca
                    </th>    
                    <th>
                        Modelo
                    </th>    
                    <th>
                        Dueño
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="vehiculoLista">
                    <tr>
                        <td><s:property value="idVehiculo"/></td>
                        <td><s:property value="modelo.marca.nombre"/></td>
                        <td><s:property value="modelo.nombre"/></td>
                        <td><s:property value="cliente.apellido"/> <s:property value="cliente.nombre"/></td>
                        <td>
                            <s:form action="editar" id="editURL" style="display:inline-block;">
                                <s:hidden name="idVehiculo" value="%{idVehiculo}"/>
                                <s:submit value="Editar" action="%{editURL}" cssClass="btn btn-info"/>
                            </s:form>
                            <s:form action="eliminar" id="deleteURL" style="display:inline-block;">
                                <s:hidden name="idVehiculo" value="%{idVehiculo}"/>
                                <s:submit value="Eliminar" action="%{deleteURL}" cssClass="btn btn-danger"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>  
            </tbody>
        </table>
    </div>
</div>