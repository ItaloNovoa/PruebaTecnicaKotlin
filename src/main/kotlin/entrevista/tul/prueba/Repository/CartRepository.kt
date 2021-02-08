package entrevista.tul.prueba.Repository

import entrevista.tul.prueba.model.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository: JpaRepository<Cart,Long> {
}