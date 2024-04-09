CREATE TABLE IF NOT EXISTS bookTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    author varchar(50) NOT NULL
);

INSERT INTO bookTable (title, author) VALUES ('Война и мир', 'Л. Н. Толстой');
INSERT INTO bookTable (title, author) VALUES ('Преступление и наказание', 'Ф. М. Достоевский');
INSERT INTO bookTable (title, author) VALUES ('Мертвые души', 'Н. В. Гоголь');
INSERT INTO bookTable (title, author) VALUES ('Мастер и Маргарита', 'М. А. Булгаков');
INSERT INTO bookTable (title, author) VALUES ('Двенадцать стульев', 'И. Ильф, Е. Петров');