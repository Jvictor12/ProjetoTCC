package io.github.jvictor12.apiestagioifba.pagamento.service;

import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apiestagioifba.pagamento.model.Pagamento;
import io.github.jvictor12.apiestagioifba.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findByAquisicao (String aquisicao) {return pagamentoRepository.findByAquisicao(aquisicao);};

    public Pagamento findById (Long id){
        return pagamentoRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Pagamento não encontrado");
        });
    }

    public Pagamento save(Pagamento pagamento){

        if(pagamento == null){
            throw new ValidationException("Pagamento nulo");
        }

        pagamentoRepository.save(pagamento);

        return pagamento;
    }

    public Pagamento update (Pagamento pagamento){

        if(pagamento == null){
            throw new ValidationException("Pagamento nulo");
        }

        if (!pagamentoRepository.existsById(pagamento.getId())) {
            throw new ValidationException("Pagamento não encontrado");
        }

        pagamentoRepository.save(pagamento);

        return pagamento;
    }

    public void deleteById (Pagamento pagamento){
        if(!pagamentoRepository.existsById(pagamento.getId())){
            throw new ValidationException("Pagamento não encontrado");
        }

        pagamentoRepository.delete(pagamento);
    }
}
