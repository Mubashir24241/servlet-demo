import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/form")
public class Formprcs extends HttpServlet {
    private static final long serialVersionUID = 1L;

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        String t1 = request.getParameter("t1");
        String t2 = request.getParameter("t2");

       
        if (t1 != null && !t1.isEmpty() && t2 != null && !t2.isEmpty()) {
         
            if (isNumeric(t1) && isNumeric(t2)) {
                int x = Integer.parseInt(t1);  
                int y = Integer.parseInt(t2);  
                int z = x + y;  
                response.getWriter().println("Sum is: " + z); 
            } else {
                response.getWriter().println("Error: Please enter valid numeric values in both fields.");
            }
        } else {
            response.getWriter().println("Error: Please enter values in both fields.");
        }
    }

  
    private boolean isNumeric(String str) {
      
        try {
            Integer.parseInt(str);  
            return true;  
        } catch (NumberFormatException e) {
            return false; 
        }
    }
}
