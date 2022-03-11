package testePratico3.maps;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

public class AdvantageShoppingMaps {
	public By spcialOffer = new ByXPath("//a[text()='SPECIAL OFFER']");
	public By seeOffer = new ByXPath("//button[text()='SEE OFFER']");
	public By productSpecifications = new ByXPath("//h2[text()='PRODUCT SPECIFICATIONS']");
	public By addToCart = new ByXPath("//button[text()='ADD TO CART']");
	public By pesquisarClicar = new ByXPath("//a[@title='SEARCH']");
	public By pesquisarPreencher = new ByXPath("//input[@id='autoComplete']");
	public By adicionarMais = new ByXPath("//div[@class='plus']");
	public By valorProduto = new ByXPath("//div[@id='Description']/h2[contains(@class,'roboto-thin')]");
	public By checkOutPopUp = new ByXPath("//button[@id='checkOutPopUp']");
	public By valorTotalProduto = new ByXPath("//label[contains(text(),'TOTAL')]//span");
	public By carrinho = new ByXPath("//a[@id='shoppingCartLink']");
	public By removeItem = new ByXPath("//a[text()='REMOVE']");
	public By carrinhoVazio = new ByXPath("//a[contains(text(),'SHOPPING')]/..//label[contains(text(),'cart is empty')]");

	public By productSpecifications(String campo, String valor) {
		return new ByXPath("//label[text()='" + campo + "']/..//label[text()='" + valor + "']/..");
	}

	public By escolherCor(String cor) {
		return new ByXPath("//span[@title='" + cor + "' and @id='bunny']");
	}

	public By corProdutoCarrinho(String cor) {
		return new ByXPath("//span[text()='" + cor + "']");
	}

	public By produto(String produtor) {
		return new ByXPath("//p[text()='" + produtor + "']");
	}

	public By notCorProdutoCarrinho(String notCor) {
		return new ByXPath("//div[@ng-show='firstImageToShow']//span[not(@title='" + notCor + "')][1]");
	}
}
