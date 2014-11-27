DROP TABLE Aluguel;
CREATE TABLE Aluguel (aluguel_oid varchar(45) NOT NULL, carro_oid varchar(45) NOT NULL, pessoa_oid varchar(45) NOT NULL, dataInicio date NOT NULL, dataFim date NOT NULL, pago bit NOT NULL, reserva_oid varchar(45) NOT NULL, PRIMARY KEY (aluguel_oid), INDEX fk_Aluguel_Carro_idx (carro_oid), INDEX fk_Aluguel_Pessoa_idx (pessoa_oid), INDEX fk_Aluguel_Reserva_idx (reserva_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE Carro;
CREATE TABLE Carro (carro_oid varchar(45) NOT NULL, modelo varchar(45) NOT NULL, placa varchar(45) NOT NULL, ano int(4) NOT NULL, ultimaManutencao date, marca varchar(45) NOT NULL, disponivel varchar(45) NOT NULL, preco decimal(50,2), diaria decimal(50,2), vendido varchar(45) NOT NULL, PRIMARY KEY (carro_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('226c015a-b641-4f35-bee5-7e63fa9926e1', 'adasd', 'daadasd', 2014, '2014-04-27', 'adasd', 'false', 121.00, 123.00, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('46583143-85e5-4a77-be06-bbde15f52f94', 'Ka', 'PLC-4567', 2014, '2014-10-02', 'Ford', 'false', 567.00, 778.00, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('512a77a2-97e5-486e-bc0e-a01bf2eabec9', 'Focus', 'FCK-1234', 2014, '2014-11-24', 'Ford', 'true', 1234.00, 123.00, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('51c3a10d-36fa-4ed0-bb21-239f45a40b83', 'Teste', 'TES-1234', 2014, '2014-11-24', 'Teste', 'true', 234224.00, 234.00, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('557706fd-da9c-4cfa-9161-a7a54410a1ce', 'Fusion', 'GKJ-8754', 2014, '2014-09-24', 'Ford', 'true', null, null, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('a6a2ee7c-0e1d-4063-939b-77d6ec17a99d', 'Teste', 'TST-1234', 2014, '2014-09-17', 'Marca Teste', 'false', 99999.00, 666.00, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('b3440c56-7558-41d0-9c7a-10e8556459d8', 'Uno', 'YUT-8678', 2014, '2014-09-16', 'Fiat', 'false', 5000.00, 100.00, 'true');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('b9d30a89-99e7-4bb7-9729-29db4d9f1069', 'Sandero', 'XYZ-9876', 2014, '2014-09-02', 'Renault', 'false', null, null, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('d14baca7-50c2-4b6a-aed9-7b97814caaea', 'Fusion', 'HJK-4566', 2014, '2014-09-24', 'Ford', 'false', null, null, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5', 'Doblo', 'ABC-1234', 2014, '2014-09-29', 'Fiat', 'true', 50000.00, 100.00, 'false');
INSERT INTO Carro (carro_oid, modelo, placa, ano, ultimaManutencao, marca, disponivel, preco, diaria, vendido) VALUES ('e55217d6-16a3-46f2-b855-7d10bd8f1396', 'Ka', 'DGD-5676', 2014, '2014-09-15', 'Ford', 'true', null, null, 'false');
DROP TABLE Filial;
CREATE TABLE Filial (filial_oid varchar(45) NOT NULL, pessoa_oid varchar(45) NOT NULL, descricao varchar(255) NOT NULL, num_Filial int NOT NULL, PRIMARY KEY (filial_oid), INDEX fk_Filial_Gerente_idx (pessoa_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO Filial (filial_oid, pessoa_oid, descricao, num_Filial) VALUES ('52b9b82b-7341-11e4-becf-7ce9d3d7fde5', 'f8b3cb2b-378c-42fd-91b7-7ac4fd61e838', 'Filial 01', 1);
DROP TABLE GrupoCarro;
CREATE TABLE GrupoCarro (grupoCarro_oid varchar(45) NOT NULL, total int, disponiveis int, descricao varchar(45) NOT NULL, PRIMARY KEY (grupoCarro_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE ListaNegra;
CREATE TABLE ListaNegra (listaNegra_oid varchar(45) NOT NULL, pessoa_oid varchar(45) NOT NULL, justificativa varchar(300), PRIMARY KEY (listaNegra_oid), INDEX fk_ListaNegra_Pessoa_idx (pessoa_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO ListaNegra (listaNegra_oid, pessoa_oid, justificativa) VALUES ('6bd3c474-1579-4c91-835f-6af3d80fead3', '0302a91b-0768-4f18-9070-383d256d968c', null);
INSERT INTO ListaNegra (listaNegra_oid, pessoa_oid, justificativa) VALUES ('8f2e688f-07a7-49d2-9991-e8c7cd56b49e', 'd013af35-29ac-4c4d-9185-313af1d8be87', null);
DROP TABLE Manutencao;
CREATE TABLE Manutencao (manutencao_oid varchar(45) NOT NULL, filal_oid varchar(45) NOT NULL, carro_oid varchar(45) NOT NULL, PRIMARY KEY (manutencao_oid), INDEX fk_Manutencao_Filial_idx (filal_oid), INDEX fk_Manutencao_Carro_idx (carro_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE Perfil;
CREATE TABLE Perfil (perfil_oid varchar(45) NOT NULL, descricao varchar(255) NOT NULL, nome varchar(45) NOT NULL, PRIMARY KEY (perfil_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE Permissao;
CREATE TABLE Permissao (permissao_oid varchar(45) NOT NULL, perfil_oid varchar(45) NOT NULL, pessoa_oid varchar(45) NOT NULL, PRIMARY KEY (permissao_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE Pessoa;
CREATE TABLE Pessoa (pessoa_oid varchar(45) NOT NULL, nome varchar(255) NOT NULL, cpf varchar(12) NOT NULL, rg varchar(10) NOT NULL, carteira varchar(10), categoriaCarteira char(1), telefone varchar(8), email varchar(45), PRIMARY KEY (pessoa_oid), CONSTRAINT pessoa_oid_UNIQUE UNIQUE (pessoa_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO Pessoa (pessoa_oid, nome, cpf, rg, carteira, categoriaCarteira, telefone, email) VALUES ('0302a91b-0768-4f18-9070-383d256d968c', 'Pessoa Teste', '444444', '23423', '23424', 'A', '44444444', 'pessoa@teste.com');
INSERT INTO Pessoa (pessoa_oid, nome, cpf, rg, carteira, categoriaCarteira, telefone, email) VALUES ('b6098f6e-8b0a-4385-924c-1f507b3c6496', 'Sildenir', '876876', '797987', '876876', 'A', '56565656', 'sildenir@email.com');
INSERT INTO Pessoa (pessoa_oid, nome, cpf, rg, carteira, categoriaCarteira, telefone, email) VALUES ('d013af35-29ac-4c4d-9185-313af1d8be87', 'Carlos', '0809809', '879879', '0897897', 'A', '90909090', 'carlos@gmail.com');
INSERT INTO Pessoa (pessoa_oid, nome, cpf, rg, carteira, categoriaCarteira, telefone, email) VALUES ('d064ae37-bf36-43d8-b499-518dc5a4f993', 'Bla', '123456', '43324', '32424', 'A', '23423456', 'bla@email.com');
INSERT INTO Pessoa (pessoa_oid, nome, cpf, rg, carteira, categoriaCarteira, telefone, email) VALUES ('dd175750-0df6-402e-8412-635703437c94', 'Diego', '99988', '53553', '5345', 'A', '78787878', 'diego@email.com');
INSERT INTO Pessoa (pessoa_oid, nome, cpf, rg, carteira, categoriaCarteira, telefone, email) VALUES ('eb9ab5f9-75b8-4079-a4ea-45344ec8a973', 'Carlos Gordo', '123123', '123123', '1231231', 'A', '56565656', 'carlos@gordo.com');
INSERT INTO Pessoa (pessoa_oid, nome, cpf, rg, carteira, categoriaCarteira, telefone, email) VALUES ('f8b3cb2b-378c-42fd-91b7-7ac4fd61e838', 'Gerente', '23123', '324234', '34234', 'A', '23343434', 'gerente@filial.com');
DROP TABLE Reserva;
CREATE TABLE Reserva (reserva_oid varchar(45) NOT NULL, pessoa_oid varchar(45) NOT NULL, carro_oid varchar(45) NOT NULL, dataInicio date NOT NULL, dataFim date NOT NULL, pagoAntecipado bit NOT NULL, PRIMARY KEY (reserva_oid), INDEX fk_Reserva_Pessoa_idx (pessoa_oid), INDEX fk_Reserva_Carro_idx (carro_oid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('24ae4ce2-dad8-4f0c-9852-eb30afb3aa84', 'dd175750-0df6-402e-8412-635703437c94', 'e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5', '2014-11-27', '2014-11-29', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('33ef0c89-75d0-431b-981b-068bf1a4a6db', 'eb9ab5f9-75b8-4079-a4ea-45344ec8a973', '46583143-85e5-4a77-be06-bbde15f52f94', '2014-10-28', '2014-10-29', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('4bd096d3-20c6-4f38-b8ec-c17d8013086d', 'eb9ab5f9-75b8-4079-a4ea-45344ec8a973', 'e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5', '2014-11-24', '2014-11-26', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('4ddad14d-c2bc-4e82-812e-f682828b00cd', '0302a91b-0768-4f18-9070-383d256d968c', 'a6a2ee7c-0e1d-4063-939b-77d6ec17a99d', '2014-10-28', '2014-10-28', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('59250fc6-5f22-4bc5-b757-b63b4888db05', 'd064ae37-bf36-43d8-b499-518dc5a4f993', '512a77a2-97e5-486e-bc0e-a01bf2eabec9', '2014-11-26', '2014-11-28', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('6954a1bc-abb1-4977-950f-0d66c2c681d4', '0302a91b-0768-4f18-9070-383d256d968c', 'a6a2ee7c-0e1d-4063-939b-77d6ec17a99d', '2014-10-28', '2014-10-28', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('77e27c9b-7810-4e4b-902f-4ec0ce8a492f', 'd013af35-29ac-4c4d-9185-313af1d8be87', 'e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5', '2014-10-01', '2014-10-02', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('a3c53bdf-180d-4573-9892-d612364b951a', 'dd175750-0df6-402e-8412-635703437c94', 'b9d30a89-99e7-4bb7-9729-29db4d9f1069', '2014-10-28', '2014-10-29', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('c16a245a-345f-471f-bf2b-8ddf55166471', 'b6098f6e-8b0a-4385-924c-1f507b3c6496', '51c3a10d-36fa-4ed0-bb21-239f45a40b83', '2014-11-03', '2014-11-06', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('cd5632a3-6952-42ac-b916-807c65759e86', '0302a91b-0768-4f18-9070-383d256d968c', 'a6a2ee7c-0e1d-4063-939b-77d6ec17a99d', '2014-10-28', '2014-10-28', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('e05e9147-ffcb-44be-bcef-2f0dab1eb820', 'b6098f6e-8b0a-4385-924c-1f507b3c6496', '51c3a10d-36fa-4ed0-bb21-239f45a40b83', '2014-11-04', '2014-11-07', false);
INSERT INTO Reserva (reserva_oid, pessoa_oid, carro_oid, dataInicio, dataFim, pagoAntecipado) VALUES ('f5042f4f-2bd8-4fdb-8b5e-da2e252ea68b', 'eb9ab5f9-75b8-4079-a4ea-45344ec8a973', 'e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5', '2014-11-10', '2014-11-14', false);
ALTER TABLE Aluguel ADD CONSTRAINT fk_Aluguel_Carro FOREIGN KEY (carro_oid) REFERENCES Carro (carro_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Aluguel ADD CONSTRAINT fk_Aluguel_Pessoa FOREIGN KEY (pessoa_oid) REFERENCES Pessoa (pessoa_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Aluguel ADD CONSTRAINT fk_Aluguel_Reserva FOREIGN KEY (reserva_oid) REFERENCES Reserva (reserva_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Filial ADD CONSTRAINT fk_Filial_Gerente FOREIGN KEY (pessoa_oid) REFERENCES Pessoa (pessoa_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ListaNegra ADD CONSTRAINT fk_ListaNegra_Pessoa FOREIGN KEY (pessoa_oid) REFERENCES Pessoa (pessoa_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Manutencao ADD CONSTRAINT fk_Manutencao_Carro FOREIGN KEY (carro_oid) REFERENCES Carro (carro_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Manutencao ADD CONSTRAINT fk_Manutencao_Filial FOREIGN KEY (filal_oid) REFERENCES Filial (filial_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Reserva ADD CONSTRAINT fk_Reserva_Carro FOREIGN KEY (carro_oid) REFERENCES Carro (carro_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Reserva ADD CONSTRAINT fk_Reserva_Pessoa FOREIGN KEY (pessoa_oid) REFERENCES Pessoa (pessoa_oid) ON DELETE NO ACTION ON UPDATE NO ACTION;