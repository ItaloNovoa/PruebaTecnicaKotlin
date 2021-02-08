package entrevista.tul.prueba.id

import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
data class ProductCartsId (var idCart:Long?=0,var idProduct:Long?=0):Serializable