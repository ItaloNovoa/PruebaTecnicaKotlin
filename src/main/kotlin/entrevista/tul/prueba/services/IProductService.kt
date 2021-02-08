package entrevista.tul.prueba.services

import entrevista.tul.prueba.model.Product

interface IProductService {

    /**
     * method to get a list of cart
     * @author italo.cufino
     */
    fun list():List<Product>


}