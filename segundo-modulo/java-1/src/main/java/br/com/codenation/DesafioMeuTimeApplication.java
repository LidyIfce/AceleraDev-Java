package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import static java.util.Comparator.*;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	Set<Time> times = new HashSet<>();
	Set<Jogador> jogadores = new HashSet<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (timeExiste(id))
			throw new IdentificadorUtilizadoException();
		times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (jogadorExiste(id))
			throw new IdentificadorUtilizadoException();
		if (!timeExiste(idTime))
			throw new TimeNaoEncontradoException();
		verificarHabilidade(nivelHabilidade);
		jogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Jogador jogador = encontrarJogadorPorId(idJogador);
		encontrarTimePorId(jogador.getIdTime()).setCapitao(jogador.getId());
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = encontrarTimePorId(idTime);
		if (time.getCapitao() == null)
			throw new CapitaoNaoInformadoException();
		return time.getCapitao();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		return encontrarJogadorPorId(idJogador).getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		return encontrarTimePorId(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (!timeExiste(idTime))
			throw new TimeNaoEncontradoException();
		return listaDeJogadoresDoTime(idTime)
				.map(Jogador::getId)
				.sorted()
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (!timeExiste(idTime))
			throw new TimeNaoEncontradoException();
		return listaDeJogadoresDoTime(idTime)
				.sorted(comparing(Jogador::getId))
				.max(comparingInt(Jogador::getNivelHabilidade))
				.map(Jogador::getId)
				.orElseThrow(() -> new JogadorNaoEncontradoException());
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		if (!timeExiste(idTime))
			throw new TimeNaoEncontradoException();
		return listaDeJogadoresDoTime(idTime)
				.min(comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.orElseThrow(() -> new JogadorNaoEncontradoException());
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return times
				.stream()
				.sorted(comparing(Time::getId))
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (!timeExiste(idTime))
			throw new TimeNaoEncontradoException();
		return listaDeJogadoresDoTime(idTime)
				.sorted(comparing(Jogador::getId))
				.max(comparing(Jogador::getSalario))
				.map(Jogador::getId)
				.orElseThrow(() -> new JogadorNaoEncontradoException());
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return encontrarJogadorPorId(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores
				.stream()
				.sorted(comparingInt(Jogador::getNivelHabilidade)
						.reversed()
						.thenComparing(Jogador::getId))
				.limit(top)
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time timeCasa = encontrarTimePorId(timeDaCasa);
		Time timeFora = encontrarTimePorId(timeDeFora);

		if (timeCasa.getCorUniformePrincipal().equalsIgnoreCase(timeFora.getCorUniformePrincipal()))
			return timeFora.getCorUniformeSecundario();

		return timeFora.getCorUniformePrincipal();
	}

    // Métodos auxiliares

	private boolean timeExiste(Long idTime) {
		return times.stream().map(Time::getId).collect(Collectors.toList()).contains(idTime);
	}

	private boolean jogadorExiste(Long idJogador) {
		return jogadores.stream().map(Jogador::getId).collect(Collectors.toList()).contains(idJogador);
	}

	private void verificarHabilidade(Integer habilidade) {
		if (habilidade < 0 || habilidade > 100)
			throw new IllegalArgumentException();
	}

	private Time encontrarTimePorId(Long idTime) {
		return times.stream().filter(x -> x.getId().equals(idTime)).findFirst().orElseThrow(() -> new TimeNaoEncontradoException());
	}

	private Jogador encontrarJogadorPorId(Long idJogador) {
		return jogadores.stream().filter(x -> x.getId().equals(idJogador)).findFirst().orElseThrow(() -> new JogadorNaoEncontradoException());
	}

	private Stream<Jogador> listaDeJogadoresDoTime(Long idTime){
		return jogadores
				.stream()
				.filter(x -> x.getIdTime().equals(idTime));
	}

}