package com.gamestore.gamestore.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.gamestore.gamestore.api.model.Categoria;


public interface CategoriaRepository extends JpaRepository{
	
	public List<Categoria> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
