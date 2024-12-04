package com.gamestore.gamestore.api.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProdutoDigital extends Produto{
	
	@NotNull(message = "O tamanho do arquivo é obrigatório.")
    @Positive(message = "O tamanho do arquivo deve ser maior que zero.")
    private BigDecimal tamanhoArquivo; // Tamanho do arquivo em GB, por exemplo

    @NotNull(message = "A plataforma é obrigatória.")
    @Size(min = 3, max = 50, message = "A plataforma deve ter entre 3 e 50 caracteres.")
    private String plataforma; // Plataforma de uso do produto (ex: Steam, PlayStation, etc.)

    @NotNull(message = "O código de ativação é obrigatória.")
    @Size(min = 3, max = 50, message = "O código de ativação deve ter entre 3 e 50 caracteres.")
    private String codigoAtivacao; // Código de ativação (caso necessário para o produto)

}
