CREATE TABLE rooms (
id_rooom INT AUTO_INCREMENT PRIMARY KEY UNIQUE,
id_stade_room INT FOREIGN KEY,
id_type_room INT FOREIGN KEY,
id_hotel INT FOREIGN KEY,
number_rooom INT NOT NULL,
price_nigth FLOAT NOT NULL,
room_amenities VARCHAR (120) NOT NULL
)
