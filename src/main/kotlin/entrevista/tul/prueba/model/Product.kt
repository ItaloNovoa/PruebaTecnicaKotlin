package entrevista.tul.prueba.model

import javax.persistence.*

@Entity
data class Product constructor (val name:String="",var sku : String= "", var description: String = ""){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0

}
