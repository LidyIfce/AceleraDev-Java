package com.challenge.desafio;
import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) {
        return somarValores(obj, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return somarValores(obj, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return somar(obj).subtract(subtrair(obj));
    }

    private <T extends Annotation> BigDecimal somarValores( Object obj, Class<T> annotation) {

        Field[] fields = obj.getClass().getDeclaredFields();
        List<BigDecimal> valores = new ArrayList<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(annotation) && field.getType().equals(BigDecimal.class)) {
                try {
                    field.setAccessible(true);
                    valores.add((BigDecimal) field.get(obj));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return valores.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
