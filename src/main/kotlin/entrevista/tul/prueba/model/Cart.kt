package entrevista.tul.prueba.model

import entrevista.tul.prueba.enums.StatusCart
import javax.persistence.*


@Entity
data class Cart  (var status: StatusCart?=StatusCart.COMPL ){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0

}