package br.ufac.sgcmapi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.model.Paciente;
import br.ufac.sgcmapi.model.Profissional;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@SpringBootApplication
@RestController
public class SgcmapiApplication {
    // @Autowired
	// private ExemploService exemploService;

	@Autowired
	private AtendimentoRepository repo;

	// public SgcmapiApplication(ExemploService exemploService){
	// 	this.exemploService = exemploService;
	// }

    @RequestMapping(value = "/teste")
	public String exemplo(){
		// return "SGCM";
		// return exemploService.exibeMensagem();

		Paciente paciente = new Paciente();
		paciente.setId(1L);

		Profissional profissional = new Profissional();
		profissional.setId(1L);

		Atendimento atendimento = new Atendimento();
		atendimento.setData(LocalDate.of(2024, 10, 11));
		atendimento.setHora(LocalTime.of(15, 00));
		atendimento.setPaciente(paciente);
		atendimento.setProfissional(profissional);


		List<Atendimento> atendimentos = repo.findAll();
		StringBuilder resultado = new StringBuilder();
		for (Atendimento item : atendimentos){
			resultado.append(item.getId()).append("\n");
			resultado.append(item.getData()).append("\n");
			resultado.append(item.getHora()).append("\n");
			resultado.append(item.getStatus()).append("\n");
			resultado.append(item.getPaciente().getNome()).append("\n");
			resultado.append(item.getProfissional().getNome()).append("\n");
			if(item.getConvenio() != null){
				resultado.append(item.getConvenio().getNome()).append("\n");
			}
			
		}
		repo.save(atendimento);
		return resultado.toString();
	}
    
	// @Service
	// public static class ExemploService{
	// 	public String exibeMensagem(){
	// 		return "SGCM funcionando!!!";
	// 	}
	// }

	public static void main(String[] args) {
		SpringApplication.run(SgcmapiApplication.class, args);
	}

}
