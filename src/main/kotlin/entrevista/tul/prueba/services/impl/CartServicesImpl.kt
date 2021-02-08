package entrevista.tul.prueba.services.impl

import entrevista.tul.prueba.Exception.BusinessException
import entrevista.tul.prueba.Exception.NotFoundException
import entrevista.tul.prueba.Repository.CartRepository
import entrevista.tul.prueba.Repository.ProductCartRepository
import entrevista.tul.prueba.enums.StatusCart
import entrevista.tul.prueba.model.Cart
import entrevista.tul.prueba.model.ProductCart
import entrevista.tul.prueba.services.ICartServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CartServicesImpl: ICartServices {

    @Autowired
    val cartRepository: CartRepository?=null

    @Autowired
    val productCartRepository: ProductCartRepository?=null

    @Throws(BusinessException::class)
    override fun list(): List<Cart> {
        try {
            return  cartRepository!!.findAll()
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun getCart(idCart: Long): Cart {
        val optionalCart: Optional<Cart>
        try {
            optionalCart = cartRepository!!.findById(idCart)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if(optionalCart.isPresent){
            return  optionalCart.get()
        }
        throw NotFoundException("El carro de compras consultado no fue encontrado $idCart")
    }

    @Throws(BusinessException::class)
    override fun checkout(idCart: Long): Cart {
        try {
            val cart:Cart= getCart(idCart)
            cart.status=StatusCart.COMPL
            return cartRepository!!.save(cart)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun addProduct(productCart: ProductCart): ProductCart {
        try {
            return productCartRepository!!.save(productCart)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun getProductsByCart(): List<ProductCart> {
        try {
            return  productCartRepository!!.findAll()
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun updateProduct(productCart: ProductCart): ProductCart {
        try {
            return productCartRepository!!.save(productCart)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun deleteProduct(productCart: ProductCart): ProductCart {
        try {
            productCartRepository!!.delete(productCart)
            return productCart
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }
}
