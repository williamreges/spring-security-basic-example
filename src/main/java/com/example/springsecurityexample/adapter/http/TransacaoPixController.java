package com.example.springsecurityexample.adapter.http;

import com.example.springsecurityexample.adapter.http.dto.TransacaoPixDTO;
import com.example.springsecurityexample.adapter.http.dto.TransacaoPixQueryVO;
import com.example.springsecurityexample.adapter.http.dto.TransacaoPixUpdateVO;
import com.example.springsecurityexample.adapter.http.dto.TransacaoPixVO;
import com.example.springsecurityexample.core.service.TransacaoPixService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/transacaopix")
public class TransacaoPixController {

    @Autowired
    private TransacaoPixService transacaoPixService;

    @PostMapping
    public String save(@Valid @RequestBody TransacaoPixVO vO) {
        return transacaoPixService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        transacaoPixService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody TransacaoPixUpdateVO vO) {
        transacaoPixService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TransacaoPixDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return transacaoPixService.getById(id);
    }

    @GetMapping
    public Page<TransacaoPixDTO> query(@Valid TransacaoPixQueryVO vO) {
        return transacaoPixService.query(vO);
    }
}
