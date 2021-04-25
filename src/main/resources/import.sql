insert into cliente (nome, sobrenome, rg, cpf, telefone, data_criacao) values ('Rafael', 'Lopes', '123465789', '9876543-96', '(85) 99632-9654', null);
insert into cliente (nome, sobrenome, rg, cpf, telefone, data_criacao) values ('Ian', 'Lopes', '321654789', '9876543-96', '(85) 99632-9654', null);
insert into cliente (nome, sobrenome, rg, cpf, telefone, data_criacao) values ('Eduardo', 'Lopes', '852369741', '9876543-96', '(85) 99632-9654', null);
insert into cliente (nome, sobrenome, rg, cpf, telefone, data_criacao) values ('Fernando', 'Lopes', '3657489621', '9876543-96', '(85) 99632-9654', null);

insert into autor (id, idade, data_nascimento, nome) values (1, 35, '1970-01-01', 'Carlos');
insert into autor (id, idade, data_nascimento, nome) values (2, 45, '1965-07-08', 'Edson');
insert into autor (id, idade, data_nascimento, nome) values (3, 60, '1940-05-05', 'Kelly');

insert into livro (id, qtd_paginas, data_publicacao, nome) values (1, 523, '2018-11-05', 'A volta dos que foram');
insert into livro (id, qtd_paginas, data_publicacao, nome) values (2, 452, '2018-11-05', 'A volta dos que não foram');
insert into livro (id, qtd_paginas, data_publicacao, nome) values (3, 352, '2017-10-01', 'Poeira em alto mar');

insert into autor_livro (id_autor, id_livro) values (1, 1);
insert into autor_livro (id_autor, id_livro) values (2, 1);
insert into autor_livro (id_autor, id_livro) values (3, 2);
insert into autor_livro (id_autor, id_livro) values (1, 2);
insert into autor_livro (id_autor, id_livro) values (3, 3);
insert into autor_livro (id_autor, id_livro) values (2, 3);
insert into autor_livro (id_autor, id_livro) values (1, 3);