package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository; //injeção de dependencia do repository em service para se conectar ao bd

    public void create(Aluno aluno) {
        alunoRepository.save(aluno); //puxando as informações do model aluno e atribuindo ao bd atravez do repository
    }

    public List<Aluno> findAll() { //findAll é para busca todos os alunos
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) { //findById esta buscando apenas um aluno com isso precisa ter parametros pois pode existir ou não
        return alunoRepository.findById(id);
    }

    public void update(Long id, Aluno aluno) { //puxando o aluno do bd para editar na memoria ram e depois devolver para o bd
        Optional<Aluno> alunoFromDb = findById(id);
        if (alunoFromDb.isEmpty()) { //condição para quando o parametro de aluno for nulo ou não existir no bd
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }

        Aluno alunoUpdated = alunoFromDb.get();

        alunoUpdated.setName(aluno.getName());
        alunoUpdated.setEmail(aluno.getEmail());

        alunoRepository.save(alunoUpdated);
    }

    public void deleteById(Long id) { //DeleteById siguinifica dizer que vamos deletar pelo usurio, dessa forma o parametro adotado sera sempre o numero do ID
        alunoRepository.deleteById(id);
    }

}
