<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="/TM/css/bootstrap.min.css" rel="stylesheet">
        <link href="/TM/css/simple-sidebar.css" rel="stylesheet">
        <link href="/TM/font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet"> 
        <link rel="stylesheet" href="/TM/css/bootstrap-datetimepicker.min.css" />
    </head>
    <body>
    <nav class="navbar navbar-default no-margin">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header fixed-brand">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"  id="menu-toggle">
                <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
            </button>
            <a class="navbar-brand" href="#"><i class="fa fa-rocket fa-4"></i> Taller Mecanico Palace</a>        
        </div><!-- navbar-header-->

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active" ><button class="navbar-toggle collapse in" data-toggle="collapse" id="menu-toggle-2"> <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span></button></li>
            </ul>
        </div><!-- bs-example-navbar-collapse-1 -->
    </nav>
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav nav-pills nav-stacked" id="menu">

                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-flash  fa-stack-1x "></i></span> Baterias</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="<s:url action="listar" namespace="/Bateria"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-list fa-stack-1x "></i></span>Todos</a></li>
                        <li><a href="<s:url action="nuevo" namespace="/Bateria"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-plus fa-stack-1x "></i></span>Nuevo</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-cogs fa-stack-1x "></i></span> Marcas</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="<s:url action="listar" namespace="/Marca"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-list fa-stack-1x "></i></span>Todos</a></li>
                        <li><a href="<s:url action="nuevo" namespace="/Marca"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-plus fa-stack-1x "></i></span>Nuevo</a></li>       
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-cogs fa-stack-1x "></i></span> Modelos</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="<s:url action="listar" namespace="/Modelo"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-list fa-stack-1x "></i></span>Todos</a></li>
                        <li><a href="<s:url action="nuevo" namespace="/Modelo"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-plus fa-stack-1x "></i></span>Nuevo</a></li>             
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-users fa-stack-1x "></i></span> Clientes</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="<s:url action="listar" namespace="/Cliente"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-list fa-stack-1x "></i></span>Todos</a></li>
                        <li><a href="<s:url action="nuevo" namespace="/Cliente"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-plus fa-stack-1x "></i></span>Nuevo</a></li>             
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-car fa-stack-1x "></i></span> Vehiculos</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="<s:url action="listar" namespace="/Vehiculo"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-list fa-stack-1x "></i></span>Todos</a></li>
                        <li><a href="<s:url action="nuevo" namespace="/Vehiculo"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-plus fa-stack-1x "></i></span>Nuevo</a></li>             
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-usd fa-stack-1x "></i></span> Ventas</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="<s:url action="listar" namespace="/Venta"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-list fa-stack-1x "></i></span>Todos</a></li>
                        <li><a href="<s:url action="nuevo" namespace="/Venta"/>"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-plus fa-stack-1x "></i></span>Nuevo</a></li>             
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid xyz">
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->

    <script src="/TM/js/jquery-2.1.1.min.js"></script>
    <script src="/TM/js/jquery-ui.min.js"></script>
    <script src="/TM/js/bootstrap.min.js"></script>
    <script src="/TM/js/moment.js"></script>
    <script src="/TM/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/TM/js/sidebar_menu.js"></script>
    <script src="/TM/js/asd.js"></script>   
    <script src="/TM/js/es.js"></script>   
</body>
</html>