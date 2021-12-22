package br.com.serratec.beestock.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.beestock.entities.Produto;
import br.com.serratec.beestock.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class PersonController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public List<Produto> finAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Produto finbyid(@PathVariable("id") Long id) {
		return service.findbyid(id);
	}
	
	@PostMapping()
	public Produto create(@RequestBody Produto produto) {
		return service.create(produto);
	}
	
	@PutMapping()
	public Produto update(@RequestBody Produto produto) {
		return service.update(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delet(@PathVariable("id") Long id) {
		service.delet(id);
		return ResponseEntity.ok().build();
	}


}
