package web;

import model.Programmer;
import services.ProgrammerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ProgrammerServlet extends HttpServlet {
    private ProgrammerService programmerService;

    public ProgrammerServlet(){
        programmerService = new ProgrammerService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(req, resp);
                break;
            case "/insert":
                insertProgrammer(req, resp);
                break;
            case "/delete":
                deleteProgrammer(req, resp);
                break;
            case "/edit":
                showEditForm(req, resp);
                break;
            case "/update":
                updateProgrammer(req, resp);
                break;
            default:
                listProgrammers(req, resp);
                break;
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("programmer-form.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Programmer existingProgrammer = programmerService.findProgrammerById(id);
        req.setAttribute("programmer", existingProgrammer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("programmer-form.jsp");
        dispatcher.forward(req, resp);
    }
    private void insertProgrammer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String city = req.getParameter("city");
        String profession = req.getParameter("profession");
        String wife = req.getParameter("wife");
        Programmer programmer = new Programmer(name, surname, city, profession, wife);
        programmerService.saveProgrammer(programmer);
        resp.sendRedirect("list");
    }
    private void updateProgrammer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String city = req.getParameter("city");
        String profession = req.getParameter("profession");
        String wife = req.getParameter("wife");
        Programmer programmer = programmerService.findProgrammerById(id);
        programmer.setName(name);
        programmer.setSurname(surname);
        programmer.setCity(city);
        programmer.setProfession(profession);
        programmer.setWife(wife);
        programmerService.updateProgrammer(programmer);
        resp.sendRedirect("list");

    }
    private void deleteProgrammer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        programmerService.deleteProgrammer(programmerService.findProgrammerById(Integer.parseInt(req.getParameter("id"))));
        resp.sendRedirect("list");
    }

    private void listProgrammers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Programmer> programmers = programmerService.findAllProgrammers();
        req.setAttribute("programmersList", programmers);
        req.getRequestDispatcher("programmer-list.jsp").forward(req, resp);
    }
}
