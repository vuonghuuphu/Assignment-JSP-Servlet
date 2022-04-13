package com.example.assignmentjspservlet.Model;

import java.time.LocalDateTime;

public class Account {
    private String username;
    private String fullname;
    private String passwordHash;
    private String salt;
    private String CreatedAt;
    private int failureCount;
    private LocalDateTime locktime;
    private int Status;
    private int Role;

    public Account() {
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", salt='" + salt + '\'' +
                ", CreatedAt='" + CreatedAt + '\'' +
                ", failureCount=" + failureCount +
                ", locktime=" + locktime +
                ", Status=" + Status +
                ", Role=" + Role +
                '}';
    }

    public Account(String username, String fullname, String passwordHash, String salt, String createdAt, int failureCount, LocalDateTime locktime, int status) {
        this.username = username;
        this.fullname = fullname;
        this.passwordHash = passwordHash;
        this.salt = salt;
        CreatedAt = createdAt;
        this.failureCount = failureCount;
        this.locktime = locktime;
        Status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public int getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(int failureCount) {
        this.failureCount = failureCount;
    }

    public LocalDateTime getLocktime() {
        return locktime;
    }

    public void setLocktime(LocalDateTime locktime) {
        this.locktime = locktime;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
