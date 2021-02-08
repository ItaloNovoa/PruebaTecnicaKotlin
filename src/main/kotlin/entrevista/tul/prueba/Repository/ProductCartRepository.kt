package entrevista.tul.prueba.Repository

import entrevista.tul.prueba.id.ProductCartsId
import entrevista.tul.prueba.model.ProductCart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCartRepository : JpaRepository<ProductCart, ProductCartsId> {
}