import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


   public class Print extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            request.getRequestDispatcher("Link.html").include(request, response);
            
            String name=request.getParameter("uname");
            String password=request.getParameter("pass");
            response.sendRedirect("MyApplet.java");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}