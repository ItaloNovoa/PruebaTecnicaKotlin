package entrevista.tul.prueba.services.impl

import entrevista.tul.prueba.Exception.BusinessException
import entrevista.tul.prueba.Repository.ProductRepository
import entrevista.tul.prueba.model.Product
import entrevista.tul.prueba.services.IProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl:IProductService {

    @Autowired
    val productRepository: ProductRepository?=null

    @Throws(BusinessException::class)
    override fun list(): List<Product> {
        try {
            return  productRepository!!.findAll()
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

}