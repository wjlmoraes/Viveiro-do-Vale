create database if not exists VIVEIRO;

use VIVEIRO

create table if not exists MUDAS (
    nome VARCHAR(50),
    quantidade INT DEFAULT 0,
    PRIMARY KEY (nome)
);

create table if not exists MUDAS_PLANTADAS (
    especie VARCHAR(50),
    data DATE,
    quant INT NOT NULL,
    PRIMARY KEY (especie, data),
    FOREIGN KEY (especie) REFERENCES MUDAS (nome) ON DELETE CASCADE
);

create table if not exists SOCIO (
    cpf VARCHAR(14),
    nome VARCHAR(80) NOT NULL,
    rua VARCHAR(80),
    numero INT DEFAULT 0,
    bairro VARCHAR(50),
    complemento VARCHAR(80),
    cidade VARCHAR(50) NOT NULL,
    estado INT NOT NULL,
    telefone VARCHAR(14),
    PRIMARY KEY (cpf)
);

create table if not exists SOCIO_TRABALHOU (
    cpf_fk VARCHAR(14),
    especie_fk VARCHAR(50),
    data DATE,
    horas TIME,
    PRIMARY KEY (cpf_fk , especie_fk , data),
    FOREIGN KEY (cpf_fk)
        REFERENCES SOCIO (cpf)
        ON DELETE CASCADE,
    FOREIGN KEY (especie_fk)
        REFERENCES MUDAS (nome)
        ON DELETE CASCADE
);

create table if not exists ADUBO (
    nome VARCHAR(50),
    quantidade FLOAT NOT NULL,
    preco FLOAT NOT NULL,
    PRIMARY KEY (nome)
);

create table if not exists ADUBO_GASTO (
    especie_fk VARCHAR(50),
    nome_ad_fk VARCHAR(50),
    quant_ad FLOAT NOT NULL,
    data DATE,
    PRIMARY KEY (especie_fk, nome_ad_fk, data),
    FOREIGN KEY (especie_fk) REFERENCES MUDAS (nome) ON DELETE CASCADE,
    FOREIGN KEY (nome_ad_fk) REFERENCES ADUBO (nome) ON DELETE CASCADE
);

create table if not exists VENDA (
    numero INT AUTO_INCREMENT,
    data DATE NOT NULL,
    PRIMARY KEY (numero)
);

create table if not exists VENDA_INCLUI (
    num_venda INT,
    especie VARCHAR(50),
    quantidade INT NOT NULL,
	preco FLOAT NOT NULL,
    PRIMARY KEY (num_venda , especie),
    FOREIGN KEY (num_venda)
        REFERENCES VENDA (numero)
        ON DELETE CASCADE,
    FOREIGN KEY (especie)
        REFERENCES MUDAS (nome)
        ON DELETE CASCADE
);

delimiter :
create trigger atualizaMudasPlantio
after insert on mudas_plantadas
for each row
begin
	update mudas
	set quantidade = quantidade + new.quant
	where nome = new.especie;
end:	

create trigger atualizaMudasVenda
after insert on venda_inclui
for each row
begin
	update mudas
	set quantidade = quantidade - new.quantidade
	where nome = new.especie;
end:

create trigger atualizaAdubo
after insert on adubo_gasto
for each row
begin
	update adubo
	set quantidade = quantidade - new.quant_ad
	where nome = new.nome_ad_fk;
end:
delimiter ;
