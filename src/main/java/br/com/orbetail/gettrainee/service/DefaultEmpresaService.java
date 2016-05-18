package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.repository.EmpresaRepository;
import br.com.orbetail.gettrainee.service.criptografia.Criptografia;
import br.com.orbetail.gettrainee.service.criptografia.CriptografiaTipo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author heitor
 * @since 17/05/16.
 */

@Service("empresaService")
public class DefaultEmpresaService implements EmpresaService {
    private EmpresaRepository empresaRepository;

    /**
     * @param empresaRepository:EmpresaRepository
     */
    public void setEmpresaRepository(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    @Override
    public Empresa salvar(Empresa empresa) {
        try {
            Criptografia criptografia = new Criptografia(CriptografiaTipo.MD5, empresa.getSenha());
            empresa.setSenha(criptografia.getEncryptedText());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return empresaRepository.save(empresa);
    }

    @Transactional
    @Override
    public void excluir(Long id) {
        empresaRepository.delete(id);
    }

    @Override
    public List<Empresa> listarTodos() {
        List<Empresa> empresas = new ArrayList<>();
        for(Empresa empresa: empresaRepository.findAll()){
            empresas.add(empresa);
        }
       return empresas;
    }

    @Override
    public Empresa buscarEmpresaPorCnpj(String cnpj) {
        return empresaRepository.findByCnpj(cnpj);
    }

    @Override
    public Set<Empresa> buscarEmpresasPorEspecializacao(String... especializacao) {
        if (especializacao == null || especializacao.length == 0)
            return new HashSet<>();

        Set<String> palavrasChave = new HashSet<>();
        Collections.addAll(palavrasChave, especializacao);

        return empresaRepository.findByEspecializacaoIn(palavrasChave);
    }
}
