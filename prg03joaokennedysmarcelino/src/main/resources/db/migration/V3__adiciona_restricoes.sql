/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  kennedy
 * Created: Nov 6, 2026
 */

ALTER TABLE pessoa   ADD CONSTRAINT uk_pessoa_cpf      UNIQUE (cpf);
ALTER TABLE usuarios ADD CONSTRAINT uk_usuarios_login  UNIQUE (login);
ALTER TABLE usuarios ALTER COLUMN login SET NOT NULL;
ALTER TABLE usuarios ADD CONSTRAINT uk_usuarios_pessoa UNIQUE (pessoa_id);
ALTER TABLE usuarios ADD CONSTRAINT fk_usuarios_pessoa
    FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);