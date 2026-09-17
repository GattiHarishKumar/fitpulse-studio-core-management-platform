package com.zumba.controller;

import com.zumba.dao.BatchDAO;
import com.zumba.model.Batch;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/batches")
public class BatchServlet extends HttpServlet {
    private BatchDAO batchDAO;

    @Override public void init() { batchDAO = new BatchDAO(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";
        try {
            switch (action) {
                case "edit": showEditForm(req, resp); break;
                case "delete": deleteBatch(req, resp); break;
                default: listBatches(req, resp); break;
            }
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Unable to process batch request.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        try {
            if ("insert".equals(action)) insertBatch(req, resp);
            else if ("update".equals(action)) updateBatch(req, resp);
            else resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown batch action.");
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Unable to save batch.", e);
        }
    }

    private void listBatches(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        req.setAttribute("batchList", batchDAO.getAllBatches());
        req.getRequestDispatcher("/list-batches.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        Batch batch = batchDAO.getBatchById(Integer.parseInt(req.getParameter("id")));
        if (batch == null) { resp.sendError(404, "Batch not found."); return; }
        req.setAttribute("batch", batch);
        req.getRequestDispatcher("/edit-batch.jsp").forward(req, resp);
    }

    private void insertBatch(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        String name = req.getParameter("batchName");
        String timeSlot = req.getParameter("timeSlot");
        int capacity = Integer.parseInt(req.getParameter("maxCapacity"));
        validateBatch(name, timeSlot, capacity);
        batchDAO.insertBatch(new Batch(name.trim(), timeSlot.trim(), capacity));
        resp.sendRedirect(req.getContextPath() + "/batches?action=list");
    }

    private void updateBatch(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("batchId"));
        String name = req.getParameter("batchName");
        String timeSlot = req.getParameter("timeSlot");
        int capacity = Integer.parseInt(req.getParameter("maxCapacity"));
        validateBatch(name, timeSlot, capacity);
        batchDAO.updateBatch(new Batch(id, name.trim(), timeSlot.trim(), capacity));
        resp.sendRedirect(req.getContextPath() + "/batches?action=list");
    }

    private void deleteBatch(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        batchDAO.deleteBatch(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath() + "/batches?action=list");
    }

    private void validateBatch(String name, String timeSlot, int capacity) {
        if (name == null || name.trim().isEmpty() || timeSlot == null || timeSlot.trim().isEmpty()
                || capacity < 1 || capacity > 100) {
            throw new IllegalArgumentException("Invalid batch details.");
        }
    }
}
