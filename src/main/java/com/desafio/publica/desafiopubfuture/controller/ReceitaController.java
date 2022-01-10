/*
 * The MIT License
 *
 * Copyright 2022 Guilherme.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.desafio.publica.desafiopubfuture.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.publica.desafiopubfuture.model.Receita;
import com.desafio.publica.desafiopubfuture.repository.ReceitaRepository;

@RestController
public class ReceitaController {

	@Autowired
	private ReceitaRepository repository;

	// Adicionar Receita
	@Transactional
	@PostMapping("/receita")
	public void salvar(@Validated @RequestBody Receita receita) {

		repository.save(receita);

	}

	// Editar Receita
	@Transactional
	@PutMapping("/receita")
	public void editar(@Validated @RequestBody Receita receita) {

		repository.save(receita);

	}

	// Excluir Receita
	@DeleteMapping("/receita/{idreceita}")
	public String delete(@PathVariable Integer idreceita) {

		repository.deleteById(idreceita);

		return "Deletado com sucesso";
	}

	// Listar todas as Receitas
	@GetMapping("/receitas")
	public List<Receita> listarTudo() {

		return repository.findAll();
	}

	// Pesquisa Receita por ID
	@GetMapping("/receita/{idReceita}")
	public Optional<Receita> findByReceita(@PathVariable Integer idReceita) {

		return repository.findById(idReceita);

	}

	// Retorna soma de todas as Receitas
	@GetMapping("/receita")
	public Double listarTotalReceita() {

		return repository.totalReceita();

	}

	// Filtrar Receitas por tipo
	@GetMapping("/receita/tipo")
	public List<Receita> listarTipoReceita(@RequestParam(name = "tipo", required = true) String tipo_receita) {

		return repository.findByTipoReceita(tipo_receita);

	}

	// Filtrar Receitas por intervalo de datas
	@GetMapping("/receita/data")
	public List<Receita> listarPorPeriodoReceita(@RequestParam(name = "inicial", required = true) Date inicial,
			@RequestParam(name = "fim", required = true) Date fim) {

		return repository.findByDataReceitaBetween(inicial, fim);

	}

}
