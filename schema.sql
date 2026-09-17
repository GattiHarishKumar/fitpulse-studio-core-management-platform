CREATE DATABASE IF NOT EXISTS zumba_db;
USE zumba_db;

DROP TABLE IF EXISTS participants;
DROP TABLE IF EXISTS batches;

CREATE TABLE batches (
    batch_id INT AUTO_INCREMENT PRIMARY KEY,
    batch_name VARCHAR(100) NOT NULL,
    time_slot VARCHAR(50) NOT NULL,
    max_capacity INT NOT NULL
);

CREATE TABLE participants (
    participant_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    batch_id INT,
    CONSTRAINT fk_batch FOREIGN KEY (batch_id)
        REFERENCES batches(batch_id)
        ON DELETE SET NULL
);

INSERT INTO batches (batch_name, time_slot, max_capacity) VALUES
('Morning Aerobics', '07:00 AM - 08:00 AM', 20),
('Evening Cardio Blast', '06:00 PM - 07:00 PM', 25);

INSERT INTO participants (full_name, email, phone, batch_id) VALUES
('Sarah Connor', 'sarah@example.com', '9876543210', 1),
('John Doe', 'john.doe@example.com', '9123456780', 2);
