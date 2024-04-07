CREATE TABLE reservations (
    id_reservation INT AUTO_INCREMENT PRIMARY KEY,
    id_user INT,
    id_rooom INT,
    id_stade_reservation INT,
    entry_date DATE,
    exit_date DATE,
    total_price FLOAT,
    CONSTRAINT FK_user FOREIGN KEY (id_user) REFERENCES users(id_user),
    CONSTRAINT FK_rooom FOREIGN KEY (id_rooom) REFERENCES roooms(id_rooom),
    CONSTRAINT FK_stade_reservation FOREIGN KEY (id_stade_reservation) REFERENCES stades_reservations(id_stade_reservation)
);
