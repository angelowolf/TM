<%-- 
    Document   : error
    Created on : 06-jul-2014, 19:50:30
    Author     : Angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css.css">
        <title>Error :(</title>
    </head>
    <body>
        
        <div class="container text-center">
            <h1>OOPS!! SE PRODUJO UN ERROR :(</h1>           

<!--            Message:-->
            <%--<%=exception.getMessage()%>--%>
            <!--StackTrace:-->
            <%
//                StringWriter stringWriter = new StringWriter();
//                PrintWriter printWriter = new PrintWriter(stringWriter);
//                exception.printStackTrace(printWriter);
//                out.println(stringWriter);
//                printWriter.close();
//                stringWriter.close();
            %>
        </div>                    
    </body>
</html>
