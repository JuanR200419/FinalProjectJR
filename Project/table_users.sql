CREATE TABLE users (
id_user INT AUTO_INCREMENT PRIMARY KEY UNIQUE,
user_rol INT NOT NULL,
full_name VARCHAR (120) NOT NULL,
age INT NOT NULL,
username VARCHAR (60) NOT NULL,
password_user VARCHAR (20) NOT NULL,
email VARCHAR (120) NOT NULL,
phone_number VARCHAR (15),
address VARCHAR(15)
)
