<%-- 
    Document   : inserir
    Created on : 03/08/2020, 14:26:48
    Author     : joao-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir item </title>
    </head>
    <body>
        
        <div class="form"> 
        <h3 class="lb1"> Cadastro Item do Estoque </h3><br/>
        
            <form action="executa_inserir.jsp" method="post">
                <label class="lb2"> Descrição     </label> 
                <input type="text" name="nome" placeholder="Descrição item" value='<% request.getParameter("nome");%>'/><br/>
                
                <label> Fornecedor </label>
                    <input type="text" name="fornecedor" placeholder="Nome fornecedor"  value='<% request.getParameter("fornecedor");%> ' /><br/>
                    
                    <label> Quantidade </label>
                    <input type="text" name="quantidade" placeholder="Quantidade do item"  value='<%  request.getParameter ("quantidade");%>'  /><br/>
                    
                    <button type="submit"> Enviar </button>
                        </form>
                    </div>
                    <style>
                  .form{ 
                      text-align: center;
                      
        
    }
    
    </style>
    </body>
</html>
