package entrevista.tul.prueba.controller

import entrevista.tul.prueba.Exception.BusinessException
import entrevista.tul.prueba.Exception.NotFoundException
import entrevista.tul.prueba.model.Cart
import entrevista.tul.prueba.model.ProductCart
import entrevista.tul.prueba.services.ICartServices
import entrevista.tul.prueba.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_CART)
class CartController {

    @Autowired
    val cartServices :ICartServices?=null

    /**
     * method to get a list of cart
     * @author italo.cufino
     */
    @GetMapping()
    fun list():ResponseEntity<List<Cart>>{
        return try {
            ResponseEntity(cartServices!!.list(),HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    /**
     * method to get a cart by id
     * @param idCart
     * @author italo.cufino
     */
    @GetMapping("/{id}")
    fun getCartById(@PathVariable(value = "id") idCart: Long):ResponseEntity<Cart>{
        return try {
            ResponseEntity(cartServices!!.getCart(idCart),HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    /**
     * method to change the status of buy cart to completed
     * @param idCart
     * @author italo.cufino
     */
    @PutMapping("/{id}")
    fun checkout(@PathVariable(value = "id") idCart: Long):ResponseEntity<Cart>{
        return try {
            ResponseEntity(cartServices!!.checkout(idCart),HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


    /**
     * method to get a list of products by cart
     * @author italo.cufino
     */
    @GetMapping("/productCart")
    fun getProductsByCart():ResponseEntity<List<ProductCart>>{
        return try {
            ResponseEntity(cartServices!!.getProductsByCart(),HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    /**
     * method to add a product to the shopping cart
     * @author italo.cufino
     */
    @PostMapping("/add-product")
    fun addProduct(@RequestBody productCart:ProductCart):ResponseEntity<Any>{
        return try {
            ResponseEntity(cartServices!!.addProduct(productCart),HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(e.message,HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


    /**
     * method to update a product to the shopping cart
     * @author italo.cufino
     */
    @PutMapping("/update-product")
    fun updateProduct(@RequestBody productCart:ProductCart):ResponseEntity<Any>{
        return try {
            ResponseEntity(cartServices!!.updateProduct(productCart),HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(e.message,HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    /**
     * method to delete a product to the shopping cart
     * @author italo.cufino
     */
    @DeleteMapping("/delete-product")
    fun deleteProduct(@RequestBody productCart:ProductCart):ResponseEntity<Any>{
        return try {
            ResponseEntity(cartServices!!.deleteProduct(productCart),HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(e.message,HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}