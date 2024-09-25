public class ex1 {

	// Declaração da Classe ContaBancaria
	public static class ContaBancaria{
	    double saldo; // Atributos da Classe
	    int contadorConsultas; 

	    // Construtor da classe
	    public ContaBancaria(double saldoInicial) {
	        this.saldo = saldoInicial; // Inicializa o saldo
	        this.contadorConsultas = 0; // Inicializa o contador de consultas
	    }

	    // Método do depósito
	    public void deposito(double valor) {
	        double taxa = valor * 0.01; // Taxa de 1% para cada depósito
	        saldo += (valor - taxa); // Contabiliza o Saldo com a Taxa
	    }

	    // Método do saque
	    public boolean saque(double valor) {
	        double taxa = valor * 0.005; // Taxa de 0,5% para cada saque
	        
	        if (saldo >= (valor + taxa)) { // Verifica se há Saldo para saque
	            saldo -= (valor + taxa); // Atualiza o Saldo com a Taxa	            
	            return true; // Saque realizado 
	            
	        } else {
	            System.out.println("Saldo insuficiente para saque."); // Informa que o saldo é insuficiente
	            return false; // Saque não realizado
	        }
	    }

	    // Método para consultar o Saldo
	    public double consultaSaldo() {
	        contadorConsultas++; // Incrementa o contador de consultas
	        
	        if (contadorConsultas % 5 == 0) { // Verifica se foram feitas 5 consultas
	            saldo -= 0.10; // Se feitas as 5 consultas, 0.10 centavos serão reduzidos do Saldo
	        }
	        return saldo; // Retorna o saldo atual
	    }

	    public static void main(String[] args) {
	      
	    	// Cria uma nova conta bancária com R$ 1000.00 de Saldo
	        ContaBancaria conta = new ContaBancaria(1000.0);

	        // Realiza um Depósito de R$ 200.00
	        conta.deposito(200.0);
	        System.out.println("Saldo após depósito: R$" + conta.consultaSaldo()); //Exibe o Saldo após o Depósito pela Consulta

	        // Realiza um Saque de R$ 100.00
	        conta.saque(100.0);
	        System.out.println("Saldo após saque: R$" + conta.consultaSaldo()); //Exibe o Saldo após o Saque pela Consulta

	        // Loop para consultar o saldo 5 vezes afim de cobrar a taxa de 0.10 centavos
	        for (int i = 0; i < 6; i++) {
	            System.out.println("Consulta " + (i + 1) + ": R$" + conta.consultaSaldo()); // Exibe o Saldo a cada Consulta
	        }
	    }
	}
}