package br.net.mirante.pde.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Period;

/**
 * Classe que cuida das conversões de um {{@link java.time.Period}}
 * para salvar e buscar do banco.
 */
@Converter
public class PeriodConverter implements AttributeConverter<Period, String> {

    @Override
    public String convertToDatabaseColumn(Period period) {
        return period.toString();
    }

    @Override
    public Period convertToEntityAttribute(String dbData) {
        return Period.parse(dbData);
    }

}
