package com.zumba.model;

public class Participant {
    private int participantId;
    private String fullName;
    private String email;
    private String phone;
    private Integer batchId;
    private String batchName;

    public Participant() {}

    public Participant(String fullName, String email, String phone, Integer batchId) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.batchId = batchId;
    }

    public Participant(int participantId, String fullName, String email, String phone, Integer batchId) {
        this.participantId = participantId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.batchId = batchId;
    }

    public int getParticipantId() { return participantId; }
    public void setParticipantId(int participantId) { this.participantId = participantId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getBatchId() { return batchId; }
    public void setBatchId(Integer batchId) { this.batchId = batchId; }
    public String getBatchName() { return batchName; }
    public void setBatchName(String batchName) { this.batchName = batchName; }
}
