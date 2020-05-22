package Cucumber.Passos;

import Constante.Utils;
import Cucumber.Steps.ConsultaProgramacaoSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultaProgramacaoPassos {

	ConsultaProgramacaoSteps program = new ConsultaProgramacaoSteps();

	@Given("^que acessou a tela principal$")
	public void acessarTelaPrincipal() throws Throwable {
		program.SetUp();
		Utils.WaitElement();
	}

	@When("^acessou o menu programacao$")
	public void acessarMenuProgramacao() throws Throwable {
		program.FecharModal();
		program.Programacao();

	}

	@When("^acessa a programacao atual$")
	public void acessarProgramacaoAtual() throws Throwable {
		program.ButtonProgramacaoAtual();
		program.ProgramacaoAtual();

	}

	@Then("^realiza a verificacao da programacao atual com sucesso$")
	public void validarProgramacaoAtual() throws Throwable {
		program.ValidacaoProgramacao();

	}

}
