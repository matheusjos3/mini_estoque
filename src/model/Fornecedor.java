package model;

import java.sql.Date;

public class Fornecedor {

    private int id_fornecedor;
    private String cnpj;
    private String nome;
    private String inicio_contrato;
    private String fim_contrato;

    public Fornecedor() {

    }

    public String toString() {
        return nome;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInicio_contrato() {
        return inicio_contrato;
    }

    public void setInicio_contrato(String inicio_contrato) {
        this.inicio_contrato = inicio_contrato;
    }

    public String getFim_contrato() {
        return fim_contrato;
    }

    public void setFim_contrato(String fim_contrato) {
        this.fim_contrato = fim_contrato;
    }
}
