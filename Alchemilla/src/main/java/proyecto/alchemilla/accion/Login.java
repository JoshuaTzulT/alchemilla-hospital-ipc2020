/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.alchemilla.accion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.businees.UserBusiness;
import proyecto.alchemilla.tranferencia.Usuario;
import proyecto.alchemilla.utilidad.CryptoUtil;
import proyecto.alchemilla.utilidad.DBUtilidad;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        password = CryptoUtil.encode(password);

        try {
            Connection conn = DBUtilidad.getConnection();
            Usuario u = UserBusiness.login(conn, username, password);

            if (u != null) {
                request.getSession().setAttribute("CURRENT_USER", u);
                conn.close();
                request.getRequestDispatcher("/WEB-INF/view/home/index.jsp").forward(request, response);
            } else {
                request.setAttribute("err", "WRONG USER OR PASSWORD");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            request.setAttribute("err", "ERROR DEL SISTEMA:" + e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

}
