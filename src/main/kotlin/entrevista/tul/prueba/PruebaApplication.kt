package entrevista.tul.prueba

import entrevista.tul.prueba.Repository.CartRepository
import entrevista.tul.prueba.Repository.ProductCartRepository
import entrevista.tul.prueba.Repository.ProductRepository
import entrevista.tul.prueba.enums.StatusCart
import entrevista.tul.prueba.model.Cart
import entrevista.tul.prueba.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PruebaApplication:CommandLineRunner{

	@Autowired
	val cartRepository: CartRepository?=null

	@Autowired
	val productRepository: ProductRepository?=null

	@Autowired
	val productCartRepository: ProductCartRepository?=null

	override fun run(vararg args: String?) {
		val cart = Cart()
		cartRepository!!.save(cart)
		val cart1 = Cart(StatusCart.COMPL)
		cartRepository!!.save(cart1)
		var product= Product()
		productRepository!!.save(product)
		product= Product("Prueba1","13881a4d8","producto de prueba1")
		productRepository!!.save(product)
		product= Product("galletas de prueba","13881a4d9","producto de prueba")
		productRepository!!.save(product)
	}
}


fun main(args: Array<String>) {
	runApplication<PruebaApplication>(*args)
}
