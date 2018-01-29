insert into MEDICO (id, crm, especialidade, idade, nome) values (1, '2222', 'Dentista', 22, 'William Douglas');
insert into MEDICO (id, crm, especialidade, idade, nome) values (2, '1234', 'Oftalmo', 32, 'Al Ries');
insert into MEDICO (id, crm, especialidade, idade, nome) values (3, '9999', 'Dentista', 51, 'Mortimer J. Adler');
insert into MEDICO (id, crm, especialidade, idade, nome) values (4, '22', 'Urologista', 19, 'Christian Barbosa');

insert into CONSULTA (id, data, espec_consulta, hora, id_med, nome_paciente) values (1, '01/01/2018', 'Dentista', '07:00',3, 'Douglas');
insert into CONSULTA (id, data, espec_consulta, hora, id_med, nome_paciente) values (2, '05/05/2018', 'Oftalmo', '08:00', 2, 'Jose');
insert into CONSULTA (id, data, espec_consulta, hora, id_med, nome_paciente) values (3, '01/01/2018', 'Dentista', '21:00', 3, 'Maria');
insert into CONSULTA (id, data, espec_consulta, hora, id_med, nome_paciente) values (4, '12/06/2018', 'Urologista', '09:00', 4, 'Pedro');
insert into CONSULTA (id, data, espec_consulta, hora, id_med, nome_paciente) values (3, '01/01/2018', 'Dentista', '18:00', 1, 'Maria');

insert into CONSULTA (id, nome) values (1, 'Unidade SP');
insert into CONSULTA (id, nome) values (2, 'PS Santa Maria');