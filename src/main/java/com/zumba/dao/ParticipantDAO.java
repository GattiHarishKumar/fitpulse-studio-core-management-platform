package com.zumba.dao;

import com.zumba.model.Participant;
import com.zumba.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    public void insertParticipant(Participant p) throws SQLException {
        String sql = "INSERT INTO participants (full_name, email, phone, batch_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getFullName());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getPhone());
            setBatchId(ps, 4, p.getBatchId());
            ps.executeUpdate();
        }
    }

    public List<Participant> getAllParticipants() throws SQLException {
        List<Participant> list = new ArrayList<>();
        String sql = "SELECT p.*, b.batch_name FROM participants p " +
                     "LEFT JOIN batches b ON p.batch_id = b.batch_id " +
                     "ORDER BY p.participant_id ASC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Participant p = new Participant(rs.getInt("participant_id"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    (Integer) rs.getObject("batch_id"));
                p.setBatchName(rs.getString("batch_name"));
                list.add(p);
            }
        }
        return list;
    }

    public Participant getParticipantById(int id) throws SQLException {
        String sql = "SELECT * FROM participants WHERE participant_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Participant(rs.getInt("participant_id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        (Integer) rs.getObject("batch_id"));
                }
            }
        }
        return null;
    }

    public void updateParticipant(Participant p) throws SQLException {
        String sql = "UPDATE participants SET full_name = ?, email = ?, phone = ?, batch_id = ? WHERE participant_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getFullName());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getPhone());
            setBatchId(ps, 4, p.getBatchId());
            ps.setInt(5, p.getParticipantId());
            ps.executeUpdate();
        }
    }

    public void deleteParticipant(int id) throws SQLException {
        String sql = "DELETE FROM participants WHERE participant_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void setBatchId(PreparedStatement ps, int index, Integer batchId) throws SQLException {
        if (batchId != null && batchId > 0) {
            ps.setInt(index, batchId);
        } else {
            ps.setNull(index, Types.INTEGER);
        }
    }
}
