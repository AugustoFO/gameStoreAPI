package com.gamestore.gamestore.api.model;

import java.math.BigDecimal;
import java.time.Year;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name = "tipo_produto", discriminatorType = DiscriminatorType.STRING)

public abstract class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do produto deve ser inserido!")
	@Size(min = 3, max = 255, message = "O nome deve conter no mínimo 3 caracteres e no máximo 255.")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	@NotNull(message = "O preço é obrigatório.")
	@Column(precision = 10, scale = 2)  // Define a precisão e escala para valores monetários
	@Min(value = 0, message = "O preço não pode ser negativo.")
    private BigDecimal preco;
	
	@PastOrPresent(message = "O ano de lançamento não pode ser no futuro.")
	private Year anoLancamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Year getAnoDeLancamento() {
		return anoLancamento;
	}

	public void setAnoDeLancamento(Year anoDeLancamento) {
		this.anoLancamento = anoDeLancamento;
	}

	public Long getId() {
		return id;
	}
	
	
}
