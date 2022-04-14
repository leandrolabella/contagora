package br.com.devleo.contagora.repositories;

import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.devleo.contagora.models.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t WHERE t.token = :token")
    public Token findByToken(@Param("token") String token);

    @Transactional
    @Modifying
    @Query("UPDATE Token t SET t.momentTokenUsed = ?2 WHERE t.token = ?1")
    int updateDateConfirmed(String token, Instant momentTokenUsed);

}
