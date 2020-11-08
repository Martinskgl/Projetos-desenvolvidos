<%@page import="java.sql.SQLException"%>
<%@page import="Model.DaoEstoque"%>
<%@page import="Model.Estoque"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
        
            try { 
                boolean resultado = false;
                Estoque est = new Estoque();
                DaoEstoque dao = new DaoEstoque();
                
                if(request.getParameter("nome") == null){
                    response.sendRedirect("index.jsp");
                } else { 
                    est.setNome(request.getParameter("nome"));
                    dao.delete(est);    
                     
                    response.sendRedirect("index.jsp");
                   
                                  
                                  
                }   
                
                
                
                
            } catch (Exception ex7) {
                throw new RuntimeException("ERRO:" + ex7);
                
            }
        
        %> 
        
        
        
    </body>
</html>
