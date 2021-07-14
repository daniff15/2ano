package lab10.ex1;

import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
		Produto p1 = new Produto("Carro mercedez", 50000);
		Produto p2 = new Produto("Computador asus", 700);
		Produto p3 = new Produto("iPhone", 700);
		Produto p4 = new Produto("Chuteiras nike", 100);
		Produto p5 = new Produto("Hotel", 1000000000);
		
		Cliente c1 = new Cliente("Dani");
		Cliente c2 = new Cliente("Eva");
		Cliente c3 = new Cliente("André");
		
		Gestor gestor = new Gestor("Pedro");
		
		//gestor adiciona os produtos no stock
		gestor.addProduto(p1);
		gestor.addProduto(p2);
		gestor.addProduto(p3);
		gestor.addProduto(p4);
		gestor.addProduto(p5);
		
		gestor.comecarLeilao(p1, 3);
		gestor.comecarLeilao(p3, 3);
		gestor.comecarLeilao(p4, 3);
		gestor.comecarLeilao(p5, 3);
		
		p1.registerObserver(c1);
		c1.licitar(p1, 50001);
		
		TimeUnit.SECONDS.sleep(1);
		p2.registerObserver(c3);
		c3.licitar(p2, 10001); 
		
		p3.registerObserver(c3);
		c3.licitar(p3, 22555);
		
		TimeUnit.SECONDS.sleep(1);
		p4.registerObserver(c1);
		c1.licitar(p4, 70001);
	
		p5.registerObserver(c2);
		c2.licitar(p5, 20001);
		
		TimeUnit.SECONDS.sleep(1);
		p1.registerObserver(c2);
		c2.licitar(p1, 50002); 
		
		TimeUnit.SECONDS.sleep(2);
		p1.registerObserver(c2);
		c2.licitar(p1, 50003); 
    }
}
