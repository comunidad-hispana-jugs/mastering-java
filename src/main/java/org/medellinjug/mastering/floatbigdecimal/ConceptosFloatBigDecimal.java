package org.medellinjug.mastering.floatbigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * Clase para explicar donde utilizar el tipo de datos flotantes o double y la clase Bigdecimal.
 * Pueden acceder en la presentación: https://bit.ly/3eSf79d
 * @author vacax
 * @since july 22, 2020
 */
public class ConceptosFloatBigDecimal {

    public static void main(String[] args) {
        problemaBase();
        noEsLoQueParece();
        floatDoubleNoSonInguales();
        desbordamiento();
        grandeYPequenoNoFuncionan();
        divisionPorCero();
        ejemploCalculoImpuesto();

        problemaBaseResuelto();
        ejemploCalculoImpuestoBigDecimal();
    }

    /**
     *
     */
    public static void problemaBase(){
        //calculo basado en double.
        double centavo = 0.01;
        double suma = centavo+centavo+centavo+centavo+centavo+centavo;
        System.out.println("el resultado es: "+suma); //¿cual es el resultado?.
    }

    /**
     *
     */
    public static void floatDoubleNoSonInguales(){
        //valores no son iguales
        float sumaFloat = 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f;
        double sumaDouble = 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d;
        System.out.println("El resulado es sumaFloat: ["+ sumaFloat+"], sumaDouble:["+sumaDouble+"]");
    }

    /**
     *
     */
    public static  void noEsLoQueParece(){
        System.out.println("El resultado es: "+ (0.3d  == (0.1d + 0.1d + 0.1d)));
    }

    /**
     *
     */
    public static  void desbordamiento(){
        double grande = 1.0e307 * 2000 / 2000;
        System.out.println("Caso Desbordamiento: "+ (grande == 1.0e307) ); //¿resultado?.
    }

    /**
     *
     */
    public static void grandeYPequenoNoFuncionan(){
        System.out.println("No debe ser igual: " + (1234.0d + 1.0e-13d == 1234.0d) ); // no se ve el efecto del número pequeño.
    }

    /**
     *
     */
    public static void divisionPorCero(){
        System.out.println(100.0 / 0.0); //Infinito
        System.out.println(-100.0 / 0.0); //- Infinito
        System.out.println(0.0 / 0.0); // NaN (No es un número)
        //int valor = 0/0;
    }

    /**
     *
     */
    public static void ejemploCalculoImpuesto() {
        System.out.println("==== Problema de redondeo ===");
        double subtotal = 100.05;
        double descuento = subtotal * 0.10;
        double total = subtotal - descuento;
        double impuesto = total * 0.05;
        double totalNeto = impuesto + total;
        //
        System.out.println("Subtotal : "+ subtotal);
        System.out.println("Descuento : " + descuento);
        System.out.println("Total : " + total);
        System.out.println("Impuesto : " + impuesto);
        System.out.println("Total + Impuesto: " + totalNeto);
        //clase para el formato.

        System.out.println("\nAplicando el redondeo\n");

        NumberFormat money = NumberFormat.getCurrencyInstance(); //HALF_EVEN
        System.out.println("Subtotal : "+ money.format(subtotal));
        System.out.println("Descuento : " + money.format(descuento));
        System.out.println("Total : " + money.format(total));
        System.out.println("Impuesto : " + money.format(impuesto));
        System.out.println("Total + Impuesto: " + money.format(totalNeto));
    }

    /**
     *
     */
    public static void problemaBaseResuelto(){
        BigDecimal suma = new BigDecimal("0.0");
        BigDecimal centavo = new BigDecimal("0.01");
        //sumando.
        suma = suma.add(centavo);
        suma = suma.add(centavo);
        suma = suma.add(centavo);
        suma = suma.add(centavo);
        suma = suma.add(centavo);
        suma = suma.add(centavo);
        System.out.println("La suma es: "+suma);
    }

    /**
     *
     */
    public static void ejemploCalculoImpuestoBigDecimal() {
        System.out.println("==== Usando BigDecimal =====");
        BigDecimal subTotal = new BigDecimal("100.05");
        BigDecimal descuentoPorcentaje = new BigDecimal("0.10");
        BigDecimal descuento = subTotal.multiply(descuentoPorcentaje);
        descuento = descuento.setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = subTotal.subtract(descuento);
        total = total.setScale(2, RoundingMode.HALF_UP);
        BigDecimal porcenjateImpuesto = new BigDecimal("0.05");
        BigDecimal impuesto = total.multiply(porcenjateImpuesto);
        impuesto = impuesto.setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxedTotal = total.add(impuesto);
        taxedTotal = taxedTotal.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Subtotal : " + subTotal);
        System.out.println("Descuento : " + descuento);
        System.out.println("Total : " + total);
        System.out.println("Impuesto : " + impuesto);
        System.out.println("Total + Impuesto (Valor Neto): " + taxedTotal);
    }
}
