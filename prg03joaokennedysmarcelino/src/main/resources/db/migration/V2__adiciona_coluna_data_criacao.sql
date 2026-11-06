/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  kennedy
 * Created: Nov 6, 2026
 */

ALTER TABLE usuarios
    ADD COLUMN data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;