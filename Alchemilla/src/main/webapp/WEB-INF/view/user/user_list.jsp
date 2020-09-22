<%@page import="proyecto.alchemilla.tranferencia.Usuario"%>
<%@page import="java.util.List"%>
<div id="principal">
<table>
    <thead>
        <tr>
            <th>#</th>
            <th>User Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Display Name</th>
        </tr>
    </thead>
    <tbody>
        <%
            int i = 1;
            List<Usuario> list = (List) request.getAttribute("list");       
        %>
        
        <%
            for(Usuario u : list){
        %>        
            
                <tr>
                    <td><%=i++%></td>
                    <td><%=u.getUserName()%></td>
                    <td><%=u.getPassword()%></td>
                    <td><%=u.getEmail()%></td>
                    <td><%=u.getDisplayName()%></td>
                </tr>
            <%}%>
        
    </tbody>
</table>
</div>            
            