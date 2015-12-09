<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="form-group">
    <s:actionmessage theme="bootstrap"/>
    <fieldset>
        <legend>
            Baterias
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
                        Nombre
                    </th> 
                    <th>
                        Precio
                    </th> 
                    <th>
                        Funciones
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="bateriaLista">
                    <tr>
                        <td><s:property value="idBateria"/></td>
                        <td><s:property value="nombre"/></td>
                        <td><s:property value="precio"/></td>
                        <td>
                            <s:form action="editar" id="editURL" style="display:inline-block;">
                                <s:hidden name="idBateria" value="%{idBateria}"/>
                                <s:submit value="Editar" action="%{editURL}" cssClass="btn btn-info"/>
                            </s:form>
                            <s:form action="eliminar" id="deleteURL" style="display:inline-block;">
                                <s:hidden name="idBateria" value="%{idBateria}"/>
                                <s:submit value="Eliminar" action="%{deleteURL}" cssClass="btn btn-danger"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>  
            </tbody>
        </table>
    </div>
</div>