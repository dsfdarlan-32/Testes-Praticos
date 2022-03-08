package testePratico3.pages;

import java.util.Map;

import testePratico3.maps.AdvantageShoppingMaps;
import testePratico3.repository.AdvantageShoppingQuerys;

public class AdvantageShoppingPage extends BasePage {
	AdvantageShoppingMaps advantageShoppingMaps;
	Float valorSemAdicionar;
	String novaCor;

	public AdvantageShoppingPage() {
		advantageShoppingMaps = new AdvantageShoppingMaps();
	}

	public void clicarSpcialOffer() {
		forceWait(4000);
		click(advantageShoppingMaps.spcialOffer);
	}

	public void clicarSeeOffer() {
		forceWait(1500);
		click(advantageShoppingMaps.seeOffer);
	}

	public void scrollPsroductSpecifications() {
		waitElement(advantageShoppingMaps.productSpecifications, 10);
		moveToDefaultContent();
	}

	/**
	 * valida descrição do produto de acordo o banco de dado
	 * 
	 * @return retorna false caso elemento da validação não exita
	 * @author dsilvafe
	 */
	public Boolean validarEspecificaçõesWebXBancoDados() {
		Boolean flag = true;
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		Map<String, String> productSpecifications;
		productSpecifications = AdvantageShoppingQuerys.productSpecificationsSelect();
		scrollDown(500);
		for (String chaveMap : productSpecifications.keySet()) {
			String coluna = chaveMap.replace("_", " ");
			String valor = productSpecifications.get(chaveMap);
			if (!isDisplayed(advantageShoppingMaps.productSpecifications(coluna, valor)))
				return false;
		}
		return flag;
	}

	public void escolherCorDB() {
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		forceWait(3000);
		Map<String, String> corDB;
		corDB = AdvantageShoppingQuerys.corSelect();
		click(advantageShoppingMaps.escolherCor(corDB.get("COLOR")));
	}

	public void adicionarProdutoCarrinho() {
		forceWait(3000);
		click(advantageShoppingMaps.addToCart);
	}

	public Boolean validarCorEscolhida() {
		forceWait(1500);
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		Map<String, String> corDB;
		corDB = AdvantageShoppingQuerys.corSelect();
		return isDisplayed(advantageShoppingMaps.corProdutoCarrinho(corDB.get("COLOR")));
	}

	public void pesquisarProdutorDB() {
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		Map<String, String> nameProductDB;
		nameProductDB = AdvantageShoppingQuerys.nameProductSelect();
		forceWait(3000);
		click(advantageShoppingMaps.pesquisarClicar);
		forceWait(1000);
		sendKeys(advantageShoppingMaps.pesquisarPreencher, nameProductDB.get("NAME_PRODUCT"));
	}

	public void cliclarProdutoPesquisado() {
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		Map<String, String> nameProductDB;
		nameProductDB = AdvantageShoppingQuerys.nameProductSelect();
		forceWait(3000);
		click(advantageShoppingMaps.produto(nameProductDB.get("NAME_PRODUCT")));
	}

	public void escolherDiferenteDaCorDB() {
		AdvantageShoppingQuerys advantageShoppingQuerys = new AdvantageShoppingQuerys();
		forceWait(3000);
		Map<String, String> corDB;
		corDB = advantageShoppingQuerys.corSelect();
		novaCor = getAttribute(advantageShoppingMaps.notCorProdutoCarrinho(corDB.get("COLOR")), "title");
		click(advantageShoppingMaps.notCorProdutoCarrinho(corDB.get("COLOR")));
	}

	public void adicionarMais() {
		forceWait(3000);
		String valoProdutor = getValue(advantageShoppingMaps.valorProduto);
		valorSemAdicionar = Float.parseFloat(valoProdutor.trim().replace("$", ""));
		click(advantageShoppingMaps.adicionarMais);
	}

	public void clicarCheckOutPopUp() {
		forceWait(3000);
		click(advantageShoppingMaps.checkOutPopUp);
	}

	public Boolean validarSomaProdutos() {
		forceWait(3000);
		String valorTotalProdutor = getValue(advantageShoppingMaps.valorTotalProduto);
		Float valorTotal = Float.parseFloat(valorTotalProdutor.trim().replace("$", ""));
		return valorTotal.equals(valorSemAdicionar * 2);
	}

	public Boolean updateCor() {
		AdvantageShoppingQuerys advantageShoppingQuerys = new AdvantageShoppingQuerys();
		return advantageShoppingQuerys.updateCorSelecionada("COLOR", novaCor);
	}

	public void cliclarCarrinho() {
		click(advantageShoppingMaps.carrinho);
	}

	public void removeItemCarrinho() {
		forceWait(1500);
		click(advantageShoppingMaps.removeItem);
	}

	public Boolean validacarrinhoVazio() {
		forceWait(1000);
		return isDisplayed(advantageShoppingMaps.carrinhoVazio);
	}
}
