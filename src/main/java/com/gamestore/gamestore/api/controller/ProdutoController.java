package com.gamestore.gamestore.api.controller;

import com.gamestore.gamestore.api.model.Produto;
import com.gamestore.gamestore.api.model.ProdutoDigital;
import com.gamestore.gamestore.api.model.ProdutoFisico;
import com.gamestore.gamestore.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/digital")
    public ResponseEntity<Produto> createProdutoDigital(@Valid @RequestBody ProdutoDigital produtoDigital) {
        Produto novoProduto = produtoRepository.save(produtoDigital);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PostMapping("/fisico")
    public ResponseEntity<Produto> createProdutoFisico(@Valid @RequestBody ProdutoFisico produtoFisico) {
        Produto novoProduto = produtoRepository.save(produtoFisico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }


    @GetMapping("/digital")
    public List<Produto> getAllProdutosDigitais() {
        return produtoRepository.findAllProdutosDigitais();
    }


    @GetMapping("/fisico")
    public List<Produto> getAllProdutosFisicos() {
        return produtoRepository.findAllProdutosFisicos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("digital/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @Valid @RequestBody ProdutoDigital produto) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        produto.setId(id);
        ProdutoDigital produtoAtualizado = produtoRepository.save(produto);
        return ResponseEntity.ok(produtoAtualizado);
    }
    
    @PutMapping("fisico/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @Valid @RequestBody ProdutoFisico produto) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        produto.setId(id);
        ProdutoFisico produtoAtualizado = produtoRepository.save(produto);
        return ResponseEntity.ok(produtoAtualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("nome/{nome}")
    public List<Produto> getProdutosByNome(@PathVariable String nome) {
        return produtoRepository.findAllByNomeContainingIgnoreCase(nome);
    }
}
