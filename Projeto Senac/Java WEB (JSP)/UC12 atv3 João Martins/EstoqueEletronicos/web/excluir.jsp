<%-- 
    Document   : excluir
    Created on : 03/08/2020, 14:23:36
    Author     : joao-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <div class="form">
            <h2> Exclusão de item</h2><br/>
            <label><strong>Descrição</strong></label> 
            <form action="executa_excluir.jsp" method="post">
                <input type="text"  name="nome" placeholder="Descrição item" value='<% request.getParameter("nome");%>' /><br/>
                
        
                    <button type="submit"> Enviar </button>
                        </form>
                </div>
        
                <style>  

                      
                             .form{ 
                      text-align: center;       
    } </style>
    
    
</style>
        
        
        
        
    </body>
</html>
