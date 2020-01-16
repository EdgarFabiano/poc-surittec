package br.com.surittec.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente extends BaseEntity<Long> {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    @NotNull
    private String cpf;

    @ManyToOne
    @JoinColumn
    private Endereco endereco;

    @Column(unique = true, nullable = false)
    @NotNull
    private String email;

    @Column(nullable = false)
    @NotNull
    private String telefone;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
