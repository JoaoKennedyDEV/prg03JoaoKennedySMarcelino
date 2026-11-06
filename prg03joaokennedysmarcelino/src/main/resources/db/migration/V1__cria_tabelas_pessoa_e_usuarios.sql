/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  kennedy
 * Created: Nov 6, 2026
 */

CREATE TABLE pessoa (
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(100),
    cpf            VARCHAR(14),
    genero         VARCHAR(20),
    datanascimento VARCHAR(10),
    telefone       VARCHAR(20),
    email          VARCHAR(120)
);

CREATE TABLE usuarios (
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    pessoa_id BIGINT,
    status    VARCHAR(20),
    login     VARCHAR(60),
    senha     VARCHAR(255)
);