package com.zumba.model;

public class Batch {
    private int batchId;
    private String batchName;
    private String timeSlot;
    private int maxCapacity;

    public Batch() {}

    public Batch(String batchName, String timeSlot, int maxCapacity) {
        this.batchName = batchName;
        this.timeSlot = timeSlot;
        this.maxCapacity = maxCapacity;
    }

    public Batch(int batchId, String batchName, String timeSlot, int maxCapacity) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.timeSlot = timeSlot;
        this.maxCapacity = maxCapacity;
    }

    public int getBatchId() { return batchId; }
    public void setBatchId(int batchId) { this.batchId = batchId; }
    public String getBatchName() { return batchName; }
    public void setBatchName(String batchName) { this.batchName = batchName; }
    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
}
