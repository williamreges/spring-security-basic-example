package com.example.springsecurityexample.core.service;

import com.example.springsecurityexample.adapter.db.TransacaoPixRepository;
import com.example.springsecurityexample.adapter.db.entity.TransacaoPix;
import com.example.springsecurityexample.adapter.http.dto.TransacaoPixDTO;
import com.example.springsecurityexample.adapter.http.dto.TransacaoPixQueryVO;
import com.example.springsecurityexample.adapter.http.dto.TransacaoPixUpdateVO;
import com.example.springsecurityexample.adapter.http.dto.TransacaoPixVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TransacaoPixService {

    @Autowired
    private TransacaoPixRepository transacaoPixRepository;

    public String save(TransacaoPixVO vO) {
        TransacaoPix bean = new TransacaoPix();
        BeanUtils.copyProperties(vO, bean);
        bean = transacaoPixRepository.save(bean);
        return bean.getCodigoTrancacao();
    }

    public void delete(String id) {
        transacaoPixRepository.deleteById(id);
    }

    public void update(String id, TransacaoPixUpdateVO vO) {
        TransacaoPix bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        transacaoPixRepository.save(bean);
    }

    public TransacaoPixDTO getById(String id) {
        TransacaoPix original = requireOne(id);
        return toDTO(original);
    }

    public Page<TransacaoPixDTO> query(TransacaoPixQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TransacaoPixDTO toDTO(TransacaoPix original) {
        TransacaoPixDTO bean = new TransacaoPixDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private TransacaoPix requireOne(String id) {
        return transacaoPixRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
