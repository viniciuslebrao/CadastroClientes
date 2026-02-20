-- Migration para adicionar coluna "imagem_produto" na tabela de produtos

ALTER TABLE tb_produto
ADD COLUMN imagem_produto VARCHAR(255);