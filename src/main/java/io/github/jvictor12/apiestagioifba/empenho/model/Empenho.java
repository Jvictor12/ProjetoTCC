package io.github.jvictor12.apiestagioifba.empenho.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.jvictor12.apiestagioifba.aquisicao.model.Aquisicao;
import io.github.jvictor12.apiestagioifba.cobranca.model.Cobranca;
import io.github.jvictor12.apiestagioifba.entrega.model.Entrega;
import io.github.jvictor12.apiestagioifba.fornecedor.model.Fornecedor;
import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import io.github.jvictor12.apiestagioifba.item.model.Item;
import io.github.jvictor12.apiestagioifba.pagamento.model.Pagamento;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_empenho")
public class Empenho extends AbstractEntity {

    @NotEmpty (message = "{field.numeroEmpenho.invalido}")
    private String numeroEmpenho;

    @Column(updatable = false)
    private String dataEmissao;

    @NotEmpty (message = "{field.valorTotalNE.invalido}")
    private String valorTotalNE;

    @NotEmpty (message = "{field.tipoEmpenho.invalido}")
    private String tipoEmpenho;

    private String dataInclusao;

    private String dataEnvio;

    @ManyToOne
    @NotNull (message = "{field.fornecedor.invalido}")
    private Fornecedor fornecedor;

    @ManyToMany
    @NotNull (message = "{field.item.invalido}")
    private List<Item> item;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "aquisicao_id")
    @NotNull (message = "{field.aquisicao.invalido}")
    private Aquisicao aquisicao;

    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Entrega entrega;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "empenho")
    private List<Cobranca> cobranca;

    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Pagamento pagamento;

}
