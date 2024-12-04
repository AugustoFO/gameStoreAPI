package com.gamestore.gamestore.api.model;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@DiscriminatorValue("FISICO")

public class ProdutoFisico extends Produto{
	
	@NotNull(message = "O peso do produto é obrigatório.")
    @DecimalMin(value = "0.01", message = "O peso deve ser maior que 0.")
    @Digits(integer = 5, fraction = 2, message = "O peso deve ter no máximo 5 dígitos antes da vírgula e 2 dígitos após.")//Valida os dados enviados
	private BigDecimal peso;
	
	@NotNull(message = "A quantidade em estoque é obrigatória.")
	@Positive(message = "A quantidade em estoque deve ser maior que zero.")
	private Integer quantidadeEstoque;

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
}
