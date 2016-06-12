package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.endereco.Cidade;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.modelbuilder.AlunoBuilder;
import br.com.orbetail.gettrainee.service.AlunoService;
import br.com.orbetail.gettrainee.service.EnderecoService;
import br.com.orbetail.gettrainee.util.JSFMensagens;
import br.com.orbetail.gettrainee.util.ValidadorCollection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;
import java.util.Set;

/**
 * @author heitor
 * @since 18/05/16.
 */
@ManagedBean
public class AlunoController {
    private final Long SAOPAULO_ID = 1L;
    private Long idCidade;
    private Long idBairro;
    private List<Cidade> cidades;
    private AlunoBuilder alunoBuilder = new AlunoBuilder();
    private List<Aluno> alunos;

    @ManagedProperty(value = "#{alunoService}")
    private AlunoService alunoService;

    /**
     * @param alunoService:AlunoService
     */
    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @ManagedProperty(value = "#{enderecoService}")
    private EnderecoService enderecoService;

    public void setEnderecoService(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    public Aluno getAluno() {
        return alunoBuilder.get();
    }

    public List<Aluno> getAlunos() {
        if (ValidadorCollection.isListNotNullOrEmpty.validar(alunos))
            return alunos;
        alunos = alunoService.listarTodos();
        return alunos;
    }

    public void onClickSubmit() {
        if(idBairro == null){
            JSFMensagens.incluirMensagemErro("idBairro NULL");
        }

    }
    
    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    public List<Cidade> getCidades() {
        if(cidades == null){
            cidades = enderecoService.listarCidadesEstado(SAOPAULO_ID);
        }
        return cidades;
    }


    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

}
