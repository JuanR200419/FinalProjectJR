CREATE TABLE reviews (
id_review INT AUTO_INCREMENT PRIMARY KEY UNIQUE,
id_reservation INT,
review_date date,
review_reservation VARCHAR (350),
CONSTRAINT FK_reservation FOREIGN KEY (id_reservation)
REFERENCES reservations(id_reservation)
)
