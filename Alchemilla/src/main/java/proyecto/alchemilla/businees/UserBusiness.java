
package proyecto.alchemilla.businees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.alchemilla.tranferencia.Usuario;

public class UserBusiness {
    
    public static Usuario login(Connection con, String username, String password) throws SQLException{
        String sql= "SELECT username, password, email, display_name FROM user WHERE username = ? and password = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        int i=1;
        stm.setString(i++, username);
        stm.setString(i++, password);
        
        ResultSet rs=stm.executeQuery();
        if(rs.next()){
            Usuario u = new Usuario();
            u.setUserName(rs.getString("username"));
            u.setEmail(rs.getString("email"));
            u.setDisplayName(rs.getString("display_name"));
            
            return u;
        }
        return null;
    }
    
    public static List<Usuario> getUserList(Connection con) throws SQLException{
        String sql = "SELECT username, password, email, display_name FROM user";
        System.out.println(sql);
        
     
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs =stm.executeQuery();
        
        List <Usuario> list =  new ArrayList<Usuario>();
        
        while(rs.next()){
            Usuario u = new Usuario();
            u.setUserName(rs.getString("username"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setDisplayName(rs.getString("display_name"));
            
            list.add(u);
            
           
        }
        return list;
    }
    
}
