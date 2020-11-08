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
    
    Estoque est = new Estoque();
    DaoEstoque dao = new DaoEstoque();
    
    if(request.getParameter("nome").equals("") || request.getParameter("fornecedor").equals("") || request.getParameter("quantidade").equals("")){
        response.sendRedirect("index.jsp");
    } else { 
        est.setNome(request.getParameter("nome"));
        est.setFornecedor(request.getParameter("fornecedor"));
        est.setQuantidade(request.getParameter("quantidade"));
        dao.insert(est);
        response.sendRedirect("index.jsp");
    }
        
} catch ( Exception ex9){
    throw new RuntimeException("ERROR9:" + ex9);
    
}    
  %>
        
        
        
    </body>
</html>
