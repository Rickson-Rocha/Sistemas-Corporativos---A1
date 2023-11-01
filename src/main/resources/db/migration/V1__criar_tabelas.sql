
CREATE TABLE autor (
    autor_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    nacionalidade VARCHAR(255)
);


CREATE TABLE livro (
    livro_id INT AUTO_INCREMENT PRIMARY KEY,
    livro_titulo VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    livro_ano_publi DATE,
    livro_quantidade_copias_disponiveis INT,
    autor_id INT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autor(autor_id)
);


CREATE TABLE usuario (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_de_registro DATE
   
);

CREATE TABLE emprestimo (
    emprestimo_id INT AUTO_INCREMENT PRIMARY KEY,
    data_de_emprestimo DATE,
    data_de_devolucao DATE,
    livro_emprestado_id INT NOT NULL,
    usuario_que_realizou_emprestimo_id INT NOT NULL,
    FOREIGN KEY (livro_emprestado_id) REFERENCES livro(livro_id),
    FOREIGN KEY (usuario_que_realizou_emprestimo_id) REFERENCES usuario(usuario_id)
);
