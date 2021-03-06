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

import com.desafio.publica.desafiopubfuture.model.Conta;
import com.desafio.publica.desafiopubfuture.model.Despesa;
import com.desafio.publica.desafiopubfuture.model.Receita;
import com.desafio.publica.desafiopubfuture.repository.ContaRepository;

@RestController
public class ContaController {

	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private ReceitaController receitaController;
	
	@Autowired
	private DespesaController despesaController;
	
	private Despesa origem;
	private Receita destino;

	// Adicionar Conta
	@Transactional
	@PostMapping("/conta")
	public void salvar(@Validated @RequestBody Conta conta) {

		repository.save(conta);

	}

	// Editar Conta
	@Transactional
	@PutMapping("/conta")
	public void editar(@Validated @RequestBody Conta conta) {

		repository.save(conta);

	}

	// Transferencia entre Contas
	@Transactional
	@PutMapping("/transferir")
	public String transferir(@RequestParam(name = "idorigem", required = true) int idorigem,
			@RequestParam(name = "iddestino", required = true) int iddestino,
			@RequestParam(name = "valor", required = true) Double valor) {

		
		

		origem = new Despesa();
		origem.setValor(valor*-1);
		origem.setTipoDespesa("Transf. para conta " + iddestino);
		origem.setId_conta(idorigem);

		destino = new Receita();
		destino.setValor(valor);
		destino.setDescricao("Transf. Recebida da conta " + idorigem);
		destino.setTipoReceita("Transferecia");
		destino.setId_conta(iddestino);

		
		receitaController.salvar(destino);
		despesaController.salvar(origem);
			


		return "Transferencia realizada com sucesso";

	}

	// Exclus?o de Conta
	@DeleteMapping("/conta/{idconta}")
	public String delete(@PathVariable Integer idconta) {

		repository.deleteById(idconta);

		return "Deletado com sucesso";
	}

	// Listar todas as Contas
	@GetMapping("/contas")
	public List<Conta> listarTudo() {

		return repository.findAll();
	}

	// Pesquisa Conta por ID
	@GetMapping("/conta/{idConta}")
	public Optional<Conta> findByConta(@PathVariable Integer idConta) {

		return repository.findById(idConta);

	}

	// Retorna soma de saldo de todas as Contas
	@GetMapping("/conta")
	public Double listarTotalConta() {

		return repository.totalConta();

	}

}
