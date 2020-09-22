
package proyecto.alchemilla.accion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.businees.UserBusiness;
import proyecto.alchemilla.tranferencia.Usuario;
import proyecto.alchemilla.utilidad.DBUtilidad;


@WebServlet(name = "UserManagement", urlPatterns = {"/UserManagement"})
public class UserManagement extends HttpServlet {

//    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action=request.getParameter("action");
        try{
            Connection conn= DBUtilidad.getConnection();
            if(action.equals("list")){
                List<Usuario>list = UserBusiness.getUserList(conn);
                String msg="no data";
                if(list.size()>0){
                    msg=list.size()+(list.size() > 1 ? "records":"record");
                }
                request.setAttribute("MSG", msg);
                request.setAttribute("list",list);
                request.getRequestDispatcher("/WEB-INF/view/user/user.jsp").forward(request, response);
            }
        }catch(IOException | ClassNotFoundException | SQLException | ServletException e){
            request.setAttribute("Error", e.getMessage());
//            request.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(request, response);
        }
        
    }

    

}
