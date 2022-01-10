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

import com.desafio.publica.desafiopubfuture.model.Despesa;

import com.desafio.publica.desafiopubfuture.repository.DespesaRepository;

@RestController
public class DespesaController {

	@Autowired
	private DespesaRepository repository;

	// Adicionar Despesa
	@Transactional
	@PostMapping("/despesa")
	public void salvar(@Validated @RequestBody Despesa despesa) {

		repository.save(despesa);

	}

	// Editar Despesas
	@Transactional
	@PutMapping("/despesa")
	public void editar(@Validated @RequestBody Despesa despesa) {

		repository.save(despesa);

	}

	// Excluir Despesas
	@DeleteMapping("/despesa/{iddespesa}")
	public String delete(@PathVariable Integer iddespesa) {

		repository.deleteById(iddespesa);

		return "Deletado com sucesso";
	}

	// Listar todas as Despesas
	@GetMapping("/despesas")
	public List<Despesa> listarTudo() {

		return repository.findAll();
	}

	// Pesquisar Despesa por ID
	@GetMapping("/despesa/{idDespesa}")
	public Optional<Despesa> findByReceita(@PathVariable Integer idDespesa) {

		return repository.findById(idDespesa);

	}

	// Retorna soma de todas as Despesas
	@GetMapping("/despesa")
	public Double listarTotalReceita() {

		return repository.totalDespesa();

	}

	// Filtrar Despesas por Tipo
	@GetMapping("/despesa/tipo")
	public List<Despesa> listarTipoReceita(@RequestParam(name = "tipo", required = true) String tipo_despesa) {

		return repository.findByTipoDespesa(tipo_despesa);

	}

	// Filtrar Despesas por intervalo de datas
	@GetMapping("/despesa/data")
	public List<Despesa> listarPorPeriodoReceita(@RequestParam(name = "inicial", required = true) Date inicial,
			@RequestParam(name = "fim", required = true) Date fim) {

		return repository.findByDataDespesaBetween(inicial, fim);

	}

}
