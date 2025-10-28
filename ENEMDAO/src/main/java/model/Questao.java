// Arquivo: Questao.java
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "questoes")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer ano;

    @Column(name = "cor_caderno", nullable = false)
    private String corCaderno;

    @Column(name = "numero_questao", nullable = false)
    private Integer numeroQuestao;

    @Column(length = 2000, nullable = false)
    private String questao;

    // Construtores
    public Questao() {}

    public Questao(Integer ano, String corCaderno, Integer numeroQuestao, String questao) {
        this.ano = ano;
        this.corCaderno = corCaderno;
        this.numeroQuestao = numeroQuestao;
        this.questao = questao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public String getCorCaderno() { return corCaderno; }
    public void setCorCaderno(String corCaderno) { this.corCaderno = corCaderno; }

    public Integer getNumeroQuestao() { return numeroQuestao; }
    public void setNumeroQuestao(Integer numeroQuestao) { this.numeroQuestao = numeroQuestao; }

    public String getQuestao() { return questao; }
    public void setQuestao(String questao) { this.questao = questao; }
}