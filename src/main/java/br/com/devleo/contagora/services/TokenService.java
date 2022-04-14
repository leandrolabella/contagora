package br.com.devleo.contagora.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devleo.contagora.models.Token;
import br.com.devleo.contagora.repositories.TokenRepository;
import br.com.devleo.contagora.repositories.UserRepository;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveConfirmation(Token token) {
        tokenRepository.save(token);
    }

    public String confirmToken(String token) {
        Token confirmToken = tokenRepository.findByToken(token);
        if (confirmToken == null) {
            return "Token inválido.";
        }
        if (confirmToken.getMomentTokenUsed() != null) {
            return "Token já confirmado.";
        }
        if (confirmToken.getMomentTokenExpire().isBefore(Instant.now())) {
            return "Token expirado.";
        }
        tokenRepository.updateDateConfirmed(token, Instant.now());
        userRepository.enableUser(confirmToken.getUser().getEmail());
        return "Token confirmado!";
    }
}
