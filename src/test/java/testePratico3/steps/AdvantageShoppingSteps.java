package testePratico3.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import testePratico3.driver.Driver;
import testePratico3.pages.AdvantageShoppingPage;

public class AdvantageShoppingSteps {
	WebDriver driver;
	AdvantageShoppingPage advantageShoppingPage;

	@After
	public void AdvantageShoppingSteps2() {
		driver.close();

	}

	public AdvantageShoppingSteps() {
		driver = Driver.getDriver();
		advantageShoppingPage = new AdvantageShoppingPage();
	}

	@Dado("Que accesso a url {string}")
	public void queAccessoAURL(String string) {
		driver.get(string);
	}

	@E("Clico na opção {string} do menu")
	public void clicoNaOpcaoDoMenu(String string) {
		advantageShoppingPage.clicarSpcialOffer();
	}

	@Quando("Clicar no botão {string}")
	public void clicarNoBotao(String string) {
		advantageShoppingPage.clicarSeeOffer();
	}

	@Então("Valido que as especificações do produto de acordo com as informações retornadas do banco de automação")
	public void validoQueAsEspecificacoesDoProdutoDeAcordoComAsInformacoesRetornadasDoBancoDeAutomacao() {
		advantageShoppingPage.scrollPsroductSpecifications();
		Assert.assertTrue(advantageShoppingPage.validarEspecificaçõesWebXBancoDados());
	}

	@E("Alterar a cor do produto de acordo com a cor informada no banco de automação")
	public void alterarACorDoProdutoDeAcordoComACorInformadaNoBancoDeAutomação() {
		advantageShoppingPage.escolherCorDB();
	}

	@E("Clicar no botão Add to cart")
	public void clicarNoBotãoAddToCart() {
		advantageShoppingPage.adicionarProdutoCarrinho();
	}

	@Então("Validar que produto foi adicionado ao carrinho com a cor selecionada")
	public void validarQueProdutoFoiAdicionadoAoCarrinhoComACorSelecionada() {
		Assert.assertTrue(advantageShoppingPage.validarCorEscolhida());
	}

	@E("Pesquiso o produto clicando no ícone de lupa {string}")
	public void pesquisoOProdutoClicandoNoÍconeDeLupa(String string) {
		advantageShoppingPage.pesquisarProdutorDB();
	}

	@E("Seleciono produto pesquisado")
	public void selecionoProdutoPesquisado() {
		advantageShoppingPage.cliclarProdutoPesquisado();
	}

	@E("Alterar a cor do produto para uma diferente da existente no banco de automação")
	public void alteraraCorDoProdutoParaUmaDiferenteDaExistenteNoBancoDeAutomação() {
		advantageShoppingPage.escolherDiferenteDaCorDB();
	}

	@E("Altero a quantidade de produtos que deseja comprar")
	public void alteroAQuantidadeDeProdutosQueDesejaComprar() {
		advantageShoppingPage.adicionarMais();
	}

	@E("Acesso a página de checkout")
	public void acessoAPáginaDeCheckout() {
		advantageShoppingPage.clicarCheckOutPopUp();
	}

	@Então("Valido que a soma dos preços corresponde ao total apresentado na página de checkout")
	public void validoQueASomaDosPreçosCorrespondeAoTotalApresentadoNaPáginaDeCheckout() {
		Assert.assertTrue(advantageShoppingPage.validarSomaProdutos());
	}

	@E("Realizo um update no banco de automação alterar a cor existente no banco para a cor selecionada no teste")
	public void realizoUmUpdateNoBancoDeAutomaçãoAlterarACorExistenteNoBancoParaACorSelecionadaNoTeste() {
		Assert.assertTrue(advantageShoppingPage.updateCor());
	}

	@E("Clicar no carrinho de compras")
	public void clicarNoCarrinhoDeCompras() {
		advantageShoppingPage.cliclarCarrinho();
	}

	@Quando("Removo produto do carrinho de compras")
	public void removoProdutoDoCarrinhoDeCompras() {
		advantageShoppingPage.removeItemCarrinho();
	}

	@Então("Valido que o carrinho de compras está vazio")
	public void validoQueOCarrinhoDeComprasEstáVazio() {
		Assert.assertTrue(advantageShoppingPage.validacarrinhoVazio());
	}
}