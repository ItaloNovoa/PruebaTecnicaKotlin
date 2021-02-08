package entrevista.tul.prueba.model

import entrevista.tul.prueba.id.ProductCartsId
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.Table

@Entity
data class ProductCart(@Id var productCartsId:ProductCartsId?=null, var quantity:Long?=0){

}
