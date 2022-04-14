package br.com.devleo.contagora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.devleo.contagora.models.Payments;
import br.com.devleo.contagora.models.User;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long>{

    @Query("SELECT p FROM Payments p WHERE p.client = :user")
    public Payments findPaymentByUser(@Param("user") User user);
    
}
