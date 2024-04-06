CREATE TABLE reservations (
id_reservation INT AUTO_INCREMENT UNIQUE,
id_user INT,
id_room INT,
id_stade_reservation INT,
entry_date date,
exit_date date,
total_price FLOAT,
CONSTRAINT FK_user FOREIGN KEY (id_users)
REFERENCES users(id_users),
CONSTRAINT FK_room FOREIGN KEY (id_room)
REFERENCES rooms(id_room),
CONSTRAINT FK_stade_reservation FOREIGN KEY (id_stade_reservation)
REFERENCES stades_reservation(id_stade_reservation)
)
