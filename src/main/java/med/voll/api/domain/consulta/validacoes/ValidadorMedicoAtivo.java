package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.repositories.MedicoRepository;

public class ValidadorMedicoAtivo {
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        // escolha do médico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser realizada com médico excluído.");
        }
    }
}
