package br.ufac.sgcmapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@SpringBootApplication
@RestController
public class SgcmapiApplication {

	@Autowired
	private ExemploService exemploService;

	@Autowired
	private AtendimentoRepository repo;

	// private final ExemploService exemploService;

	// public SgcmapiApplication(ExemploService exemploService) {
	// 	this.exemploService = exemploService;
	// }

	@RequestMapping(value = "/teste")
	public String exemplo() {
		// return "SGCM";
		// return exemploService.exibeMensagem();
		List<Atendimento> atendimentos = repo.findAll();
		StringBuilder resultado = new StringBuilder();
		for (Atendimento item : atendimentos) {
			resultado.append(item.getId() + "\n");
			resultado.append(item.getData() + "\n");
			resultado.append(item.getHora() + "\n");
			resultado.append(item.getStatus() + "\n");
			resultado.append(item.getPaciente().getNome() + "\n");
			resultado.append(item.getProfissional().getNome() + "\n");

			if (item.getConvenio() != null) {
				resultado.append(item.getConvenio().getNome() + "\n");
			}
		}
		return resultado.toString();
	}

	@Service
	public static class ExemploService {
		public String exibeMensagem() {
			return "SGCM funcionando!!!";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SgcmapiApplication.class, args);
	}

}
