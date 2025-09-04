package murach.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.business.User;
import murach.data.UserDB;

public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set request and response encoding to handle Vietnamese characters
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        // get parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String heardFrom = request.getParameter("heardFrom");
        String wantsUpdates = request.getParameter("wantsUpdates");
        String emailOK = request.getParameter("emailOK");
        String contactVia = request.getParameter("contactVia");
        
        // process parameters
        if (heardFrom == null) {
            heardFrom = "NA";
        }
        if (wantsUpdates == null) {
            wantsUpdates = "No";
        }
        else {
            wantsUpdates = "Yes";
        }
        if (emailOK == null) {
            emailOK = "No";
        }
        else {
            emailOK = "Yes";
        }
        
        // Handle empty dateOfBirth
        if (dateOfBirth == null) {
            dateOfBirth = "";
        }
        
        // store data in User object
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setDateOfBirth(dateOfBirth);
        user.setHeardFrom(heardFrom);        
        user.setWantsUpdates(wantsUpdates);
        user.setEmailOK(emailOK);
        user.setContactVia(contactVia);

        // store User object in database (placeholder)
        UserDB.insert(user);

        // store User object in request
        request.setAttribute("user", user);

        // forward request to JSP
        String url = "/survey.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect GET requests to the survey form
        response.sendRedirect("index.html");
    }
}