package br.net.mirante.pde.repository.custom;

import br.net.mirante.pde.entity.Pessoa;
import br.net.mirante.pde.entity.QPessoa;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named
public class PessoaRepositoryImpl implements PessoaRepositoryCustom {

    @Inject
    EntityManager em;

    private QPessoa pessoa = QPessoa.pessoa;

    private JPAQuery<Pessoa> pessoaQuery() {
        return new JPAQueryFactory(em).select(pessoa).from(pessoa);
    }

    @Override
    public List<Pessoa> filtrar(String filtro) {
        JPAQuery<Pessoa> query = pessoaQuery();

        BooleanBuilder builder = new BooleanBuilder();
        builder.or(pessoa.nome.likeIgnoreCase(filtro));
        builder.or(pessoa.cpf.likeIgnoreCase(filtro));
        //TODO continuar

        query.where(builder);
        return query.fetch();
    }

}
