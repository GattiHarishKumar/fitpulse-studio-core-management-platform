package com.zumba.controller;

import com.zumba.dao.BatchDAO;
import com.zumba.dao.ParticipantDAO;
import com.zumba.model.Batch;
import com.zumba.model.Participant;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/participants")
public class ParticipantServlet extends HttpServlet {
    private ParticipantDAO participantDAO;
    private BatchDAO batchDAO;

    @Override public void init() {
        participantDAO = new ParticipantDAO();
        batchDAO = new BatchDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";
        try {
            switch (action) {
                case "new": showNewForm(req, resp); break;
                case "edit": showEditForm(req, resp); break;
                case "delete": deleteParticipant(req, resp); break;
                default: listParticipants(req, resp); break;
            }
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Unable to process participant request.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        try {
            if ("insert".equals(action)) insertParticipant(req, resp);
            else if ("update".equals(action)) updateParticipant(req, resp);
            else resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown participant action.");
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Unable to save participant.", e);
        }
    }

    private void listParticipants(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        req.setAttribute("participantList", participantDAO.getAllParticipants());
        req.getRequestDispatcher("/list-participants.jsp").forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        req.setAttribute("batches", batchDAO.getAllBatches());
        req.getRequestDispatcher("/add-participant.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        Participant p = participantDAO.getParticipantById(Integer.parseInt(req.getParameter("id")));
        if (p == null) { resp.sendError(404, "Participant not found."); return; }
        req.setAttribute("participant", p);
        req.setAttribute("batches", batchDAO.getAllBatches());
        req.getRequestDispatcher("/edit-participant.jsp").forward(req, resp);
    }

    private void insertParticipant(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        String name = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        Integer batchId = parseOptionalBatch(req.getParameter("batchId"));
        validateParticipant(name, email, phone);
        participantDAO.insertParticipant(new Participant(name.trim(), email.trim(), phone.trim(), batchId));
        resp.sendRedirect(req.getContextPath() + "/participants?action=list");
    }

    private void updateParticipant(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("participantId"));
        String name = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        Integer batchId = parseOptionalBatch(req.getParameter("batchId"));
        validateParticipant(name, email, phone);
        participantDAO.updateParticipant(new Participant(id, name.trim(), email.trim(), phone.trim(), batchId));
        resp.sendRedirect(req.getContextPath() + "/participants?action=list");
    }

    private void deleteParticipant(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        participantDAO.deleteParticipant(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath() + "/participants?action=list");
    }

    private Integer parseOptionalBatch(String value) {
        return value == null || value.trim().isEmpty() ? null : Integer.valueOf(value);
    }

    private void validateParticipant(String name, String email, String phone) {
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty()
                || phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Name, email and phone are required.");
        }
    }
}
