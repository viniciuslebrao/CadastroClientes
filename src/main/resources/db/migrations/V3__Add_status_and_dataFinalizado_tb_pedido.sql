-- Migration que adiciona coluna de data_de_finalizacao e status na tabela pedido

ALTER TABLE tb_pedido
ADD COLUMN data_de_finalizacao TIMESTAMP;

ALTER TABLE tb_pedido
ADD COLUMN status VARCHAR(100) NOT NULL;