package com.zumba.dao;

import com.zumba.model.Batch;
import com.zumba.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {
    public void insertBatch(Batch batch) throws SQLException {
        String sql = "INSERT INTO batches (batch_name, time_slot, max_capacity) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, batch.getBatchName());
            ps.setString(2, batch.getTimeSlot());
            ps.setInt(3, batch.getMaxCapacity());
            ps.executeUpdate();
        }
    }

    public List<Batch> getAllBatches() throws SQLException {
        List<Batch> batches = new ArrayList<>();
        String sql = "SELECT * FROM batches ORDER BY batch_id ASC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                batches.add(new Batch(rs.getInt("batch_id"),
                    rs.getString("batch_name"),
                    rs.getString("time_slot"),
                    rs.getInt("max_capacity")));
            }
        }
        return batches;
    }

    public Batch getBatchById(int id) throws SQLException {
        String sql = "SELECT * FROM batches WHERE batch_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Batch(rs.getInt("batch_id"),
                        rs.getString("batch_name"),
                        rs.getString("time_slot"),
                        rs.getInt("max_capacity"));
                }
            }
        }
        return null;
    }

    public void updateBatch(Batch batch) throws SQLException {
        String sql = "UPDATE batches SET batch_name = ?, time_slot = ?, max_capacity = ? WHERE batch_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, batch.getBatchName());
            ps.setString(2, batch.getTimeSlot());
            ps.setInt(3, batch.getMaxCapacity());
            ps.setInt(4, batch.getBatchId());
            ps.executeUpdate();
        }
    }

    public void deleteBatch(int id) throws SQLException {
        String sql = "DELETE FROM batches WHERE batch_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
