package entrevista.tul.prueba.services

import entrevista.tul.prueba.model.Cart
import entrevista.tul.prueba.model.ProductCart

interface ICartServices {

    /**
     * method to get a list of cart
     * @author italo.cufino
     */
    fun list(): List<Cart>

    /**
     * method to get a cart by id
     * @param idCart
     * @author italo.cufino
     */
    fun getCart(idCart:Long): Cart

    /**
     * method to change the status of buy cart to completed
     * @param idCart
     * @author italo.cufino
     */
    fun checkout(idCart:Long):Cart

    /**
     * method to add a product to the shopping cart
     * @author italo.cufino
     */
    fun addProduct(productCart: ProductCart): ProductCart

    /**
     * method to get a list of products by cart
     * @author italo.cufino
     */
    fun getProductsByCart():  List<ProductCart>

    /**
     * method to update a product to the shopping cart
     * @author italo.cufino
     */
    fun updateProduct(productCart: ProductCart): ProductCart

    /**
     * method to delete a product to the shopping cart
     * @author italo.cufino
     */
    fun deleteProduct(productCart: ProductCart): ProductCart
}