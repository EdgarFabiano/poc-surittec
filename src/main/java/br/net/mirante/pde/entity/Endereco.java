package br.net.mirante.pde.entity;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Entity
@Table(uniqueConstraints= @UniqueConstraint(columnNames={"cep", "numero"}))
public class Endereco extends BaseEntity<Long> {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String logradouro;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @JoinColumn
    @ManyToOne
    private UF uf;

    @Column
    private String cep;

    @Override
    public Long getCod() {
        return getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        String separator = "-";
        HashSet<String> enderecos = new HashSet<>();
        enderecos.add(logradouro);
        enderecos.add(numero);
        enderecos.add(bairro);
        enderecos.add(cidade);
        enderecos.add(uf.getSigla());
        enderecos.removeIf(Objects::isNull);
        return Joiner.on(separator).join(enderecos);
    }
}
