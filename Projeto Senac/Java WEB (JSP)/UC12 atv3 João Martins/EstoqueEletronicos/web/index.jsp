 <%@page import="java.util.ArrayList"%>
<%@page import="Model.Estoque"%>
<%@page import="Model.DaoEstoque"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estoque</title>
    </head>
    <body>
        
        <div class="form">
    <form action="index.jsp" method="post">
            <h1 class="label"> Estoque Eletrônicos </h1><br/>
            <button class="btn2" style="color: yellowgreen" type="submit"> Atualizar </button>
    </form>
               
        <% 
        
        try{
            
            DaoEstoque dao = new DaoEstoque();
            Estoque est = new Estoque();
            
            out.print("<table border=1 background");
            out.print("<tr>");
            out.print("<th> Código </th> <th> Nome </td> <th> Fornecedor </th> <th> Quantidade </th><th> Excluir </th>");
            
            if(request.getParameter("nome") == "" || request.getParameter("nome") == null){
                ArrayList<Estoque> lista = dao.Listartodos();
                for(int num=0; num < lista.size(); num++){
                    out.print("<tr>");
                    out.print("<td>"+lista.get(num).getId()+"</td>");
                    out.print("<td>"+lista.get(num).getNome()+"</td>");
                    out.print("<td>"+lista.get(num).getFornecedor()+"</td>");
                    out.print("<td>"+lista.get(num).getQuantidade()+"</td>");
                    out.print("<td><a href='excluir.jsp?nome="+lista.get(num).getNome()+"'> Excluir </a></td>" );
                    out.print("</tr>");
                } 
            } else {
                if(request.getParameter("nome") == "" || request.getParameter("") == null){
                ArrayList<Estoque> lista = dao.ListarTodosDescri();
                for(int num=0; num < lista.size(); ++num){
                    out.print("<tr>");
                    out.print("<td>"+lista.get(num).getId()+"</td>");
                    out.print("<td>"+lista.get(num).getNome()+"</td>");
                    out.print("<td>"+lista.get(num).getFornecedor()+"</td>");
                    out.print("<td>"+lista.get(num).getQuantidade()+"</td>");
                    out.print("<td><a href='excluir.jsp?nome="+lista.get(num).getNome()+"'> excluir </a></td>" );
                    out.print("</tr>");
            }
                                
            out.print("</tr>");
            out.print("</table>");
            
            
       }
            }
        }catch(Exception ex9){
            throw new RuntimeException("ERROR:" + ex9);
            
        }
        
        %>
        </div>
        <button class="btn"> <a href="inserir.jsp"> Adicionar Item </a> </button>
    </body>
</html>


<style>  

    .form{ 
        
        margin-left: 500px;
        margin-top: 250px;
    }
    .label{     
        margin-left: 55px;
    }
   .btn { 
   margin-left: 110px;
   }
   
   .btn2 { 
   margin-left: 125px;
   }
</style>
