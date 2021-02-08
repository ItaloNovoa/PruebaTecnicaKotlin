package entrevista.tul.prueba.controller

import entrevista.tul.prueba.model.Cart
import entrevista.tul.prueba.model.Product
import entrevista.tul.prueba.services.IProductService
import entrevista.tul.prueba.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(Constants.URL_BASE_PRODUCT)
class ProductController {

    @Autowired
    val productService:IProductService?=null


    @GetMapping()
    fun list(): ResponseEntity<List<Product>> {
        return try {
            ResponseEntity(productService!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}