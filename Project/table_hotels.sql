CREATE TABLE hotels (
id_hotel INT AUTO_INCREMENT PRIMARY KEY UNIQUE,
name_hotel VARCHAR (120) NOT NULL,
address_hotel VARCHAR (120) NOT NULL UNIQUE,
classification_hotel VARCHAR (6) NOT NULL,
mob_cons_hotel VARCHAR (120) NOT NULL,
pictures_hotel VARCHAR (120)
)
