package br.com.surittec.repository.custom;

import br.com.surittec.entity.Cliente;
import br.com.surittec.entity.QCliente;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named
public class ClienteRepositoryImpl implements ClienteRepositoryCustom {

    @Inject
    EntityManager em;

    private QCliente cliente = QCliente.cliente;

    private JPAQuery<Cliente> clienteQuery() {
        return new JPAQueryFactory(em).select(cliente).from(cliente);
    }

    @Override
    public List<Cliente> filtrar(String filtro) {
        JPAQuery<Cliente> query = clienteQuery();

        BooleanBuilder builder = new BooleanBuilder();
        builder.or(cliente.nome.likeIgnoreCase(filtro));
        builder.or(cliente.cpf.likeIgnoreCase(filtro));
        //TODO continuar

        query.where(builder);
        return query.fetch();
    }

}
