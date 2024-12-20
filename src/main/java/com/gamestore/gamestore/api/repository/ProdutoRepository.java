package com.gamestore.gamestore.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamestore.gamestore.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List <Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
	 @Query("SELECT p FROM Produto p WHERE TYPE(p) = ProdutoDigital")
    List<Produto> findAllProdutosDigitais();

	 @Query("SELECT p FROM Produto p WHERE TYPE(p) = ProdutoFisico")
    List<Produto> findAllProdutosFisicos();

}
