package entrevista.tul.prueba.Repository


import entrevista.tul.prueba.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
}