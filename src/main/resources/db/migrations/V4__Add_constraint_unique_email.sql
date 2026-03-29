-- Migration corrige a falta de unicidade no email

ALTER TABLE tb_cliente
ADD CONSTRAINT uk_cliente_email UNIQUE (email);