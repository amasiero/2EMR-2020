drop sequence sq_aluno;
drop table tb_aluno;

create table tb_aluno (
	id number primary key not null,
	rm number not null,
	nome varchar2(100) not null,
	ativo number(1) default 1,
	nota1 number(3,1) not null,
	nota2 number(3,1) not null
);

create sequence sq_aluno increment by 1 start with 1 nocycle order;