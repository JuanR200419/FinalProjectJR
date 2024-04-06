CREATE TABLE rooms (
id_rooom INT AUTO_INCREMENT PRIMARY KEY UNIQUE,
id_stade_room INT,
id_type_room INT,
id_hotel INT,
number_rooom INT NOT NULL,
price_nigth FLOAT NOT NULL,
room_amenities VARCHAR (120) NOT NULL,
CONSTRAINT FK_hotel FOREIGN KEY (id_hotel)
REFERENCES hotels(id_hotel),
CONSTRAINT FK_stade_room FOREIGN KEY (id_stade_room)
REFERENCES stades_room(id_stade_room),
CONSTRAINT FK_types_room FOREIGN KEY (id_type_room)
REFERENCES types_room(id_type_room)
)
