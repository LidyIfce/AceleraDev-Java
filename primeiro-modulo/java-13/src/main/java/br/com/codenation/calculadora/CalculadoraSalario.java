package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		Double salarioMenosINSS = calcularInss(salarioBase);
		Double salarioLiquido = calcularIRRF(salarioMenosINSS);
		return Math.round(salarioLiquido);
	}

	private double calcularInss(double salarioBase) {
		Double valorLiquido = salarioBase;
		if(salarioBase <= 1500){
			valorLiquido -= salarioBase * 0.08;
		}else if(salarioBase <= 4000){
			valorLiquido -= salarioBase * 0.09;
		}else{
			valorLiquido -= salarioBase * 0.11;
		}
		return valorLiquido;
	}

	private double calcularIRRF(double salarioBrutoMenosINSS) {
		if(salarioBrutoMenosINSS < 1039.00){
			return 0.0;
		}
		Double valorLiquido = salarioBrutoMenosINSS;
		if(salarioBrutoMenosINSS > 3000 && salarioBrutoMenosINSS <= 6000){
			valorLiquido -= salarioBrutoMenosINSS * 0.075;
		}else if(salarioBrutoMenosINSS > 6000){
			valorLiquido -= salarioBrutoMenosINSS * 0.15;
		}

		return valorLiquido;
	}
}