package br.com.orbetail.gettrainee.modelbuilder;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.endereco.Bairro;
import br.com.orbetail.gettrainee.model.endereco.Cidade;
import br.com.orbetail.gettrainee.model.endereco.Estado;
import br.com.orbetail.gettrainee.model.endereco.Pais;
import br.com.orbetail.gettrainee.model.endereco.Rua;

/**
 * @author heitor
 * @since 10/05/16.
 */
public class EnderecoBuilder {
    private String numero;
    private Rua rua;
    private Bairro bairro;
    private Cidade cidade;
    private Estado estado;
    private Pais pais;

    public EnderecoBuilder() {
        this.rua = new Rua();
        this.bairro = new Bairro();
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.pais = new Pais();
    }

    public EnderecoBuilder numero(String numero) {
        this.numero = numero;
        return this;
    }

    public EnderecoBuilder rua(String rua) {
        this.rua.setRua(rua);
        return this;
    }

    public EnderecoBuilder bairro(String bairro) {
        this.bairro.setBairro(bairro);
        return this;
    }

    public EnderecoBuilder cidade(String cidade) {
        this.cidade.setCidade(cidade);
        return this;
    }

    public EnderecoBuilder estado(String estado) {
        this.estado.setEstado(estado);
        return this;
    }

    public EnderecoBuilder pais(String pais) {
        this.pais.setPais(pais);
        return this;
    }

    public Endereco get() {
        Endereco endereco = new Endereco();
        endereco.setNumero(numero);
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setPais(pais);
        return endereco;
    }


}
