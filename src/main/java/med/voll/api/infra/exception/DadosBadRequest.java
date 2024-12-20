package med.voll.api.infra.exception;

import org.springframework.validation.FieldError;

public record DadosBadRequest(String campo, String mensagem) {
    public DadosBadRequest(FieldError erro) {
        this(erro.getField(), erro.getDefaultMessage());
    }
}
