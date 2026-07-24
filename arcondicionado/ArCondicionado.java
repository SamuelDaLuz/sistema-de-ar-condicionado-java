package arcondicionado;
import java.util.Scanner;

public class ArCondicionado {
    private String marca;
    private int temperaturaAtual;
    private int temperaturaMinima;
    private int temperaturaMaxima;
    private boolean ligado;
    private String modo;
    private int velocidadeVentilador;

    public ArCondicionado(String marca) {
        this.marca = marca;
        this.temperaturaAtual = 22;
        this.temperaturaMinima = 14;
        this.temperaturaMaxima = 31;
        this.ligado = false;
        this.modo = "FRIO";
        this.velocidadeVentilador = 1;
    }

    public void ligarDesligar() {
        this.ligado = !this.ligado;
        System.out.println("Aparelho " + (this.ligado ? "LIGADO" : "DESLIGADO"));
    }

    public String aumentarTemperatura() {
        String msg = "Erro: O aparelho está desligado!";
        if (validarLigado()) {
            if (this.temperaturaAtual < this.temperaturaMaxima) {
                this.temperaturaAtual++;
                msg = "Temperatura aumentada para: " + this.temperaturaAtual + "°C";
            } else {
                msg = "Aviso: Temperatura maxima (" + this.temperaturaMaxima + "°C) atingida.";
            }
        }
        return msg;
    }

    public void diminuirTemperatura() {
        if (validarLigado()) {
            if (this.temperaturaAtual > this.temperaturaMinima) {
                this.temperaturaAtual--;
                System.out.println("Temperatura diminuida para: " + this.temperaturaAtual + "  ");
            } else {
                System.out.println("Aviso: Temperatura minima (" + this.temperaturaMinima + "  ) atingida.");
            }
        }
    }

    public void trocarModo(String novoModo) {
        if (validarLigado()) {
            String modoUpper = novoModo.toUpperCase();
            if (modoUpper.equals("FRIO") || modoUpper.equals("QUENTE") || modoUpper.equals("VENTILAR")) {
                this.modo = modoUpper;
                System.out.println("Modo alterado para: " + this.modo);
            } else {
                System.out.println("Erro: Modo invalido. Use FRIO, QUENTE ou VENTILAR.");
            }
        }
    }

    public void aumentarVelocidade() {
        if (validarLigado()) {
            if (this.velocidadeVentilador < 3) {
                this.velocidadeVentilador++;
                System.out.println("Velocidade aumentada para: " + this.velocidadeVentilador);
            } else {
                System.out.println("Aviso: Velocidade maxima (3) atingida.");
            }
        }
    }

    public void diminuirVelocidade() {
        if (validarLigado()) {
            if (this.velocidadeVentilador > 1) {
                this.velocidadeVentilador--;
                System.out.println("Velocidade diminuida para: " + this.velocidadeVentilador);
            } else {
                System.out.println("Aviso: Velocidade minima (1) atingida.");
            }
        }
    }

    public void mostrarStatus() {
        System.out.println("\n--- STATUS ---");
        System.out.println("Marca: " + this.marca);
        System.out.println("Estado: " + (this.ligado ? "Ligado" : "Desligado"));
        System.out.println("Temperatura Atual: " + this.temperaturaAtual + "  ");
        System.out.println("Modo: " + this.modo);
        System.out.println("Velocidade: " + this.velocidadeVentilador);
        System.out.println("--------------------------");
    }

    private boolean validarLigado() {
        if (!this.ligado) {
            System.out.println("Operacao nao permitida. O aparelho esta desligado.");
            return false;
        }
        return true;
    }

    // Getters e Setters conforme necessário
    public String getMarca() { return marca; }
    public int getTemperaturaAtual() { return temperaturaAtual; }
    public boolean isLigado() { return ligado; }
}

class Execucao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe a marca do ar-condicionado: ");
        String marca = entrada.nextLine();
        
        ArCondicionado ar = new ArCondicionado(marca);
        int opcao = 8;

        while (opcao != 0) {
            System.out.println("\n------ MENU AR-CONDICIONADO ------");
            System.out.println("1 - Ligar/desligar");
            System.out.println("2 - Aumentar temperatura");
            System.out.println("3 - Diminuir temperatura");
            System.out.println("4 - Trocar modo");
            System.out.println("5 - Aumentar velocidade");
            System.out.println("6 - Diminuir velocidade");
            System.out.println("7 - Mostrar status");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    ar.ligarDesligar();
                    break;
                case 2:
                    System.out.println(ar.aumentarTemperatura());
                    break;
                case 3:
                    ar.diminuirTemperatura();
                    break;
                case 4:
                    System.out.print("Informe o modo (FRIO, QUENTE, VENTILAR): ");
                    String novoModo = entrada.nextLine();
                    ar.trocarModo(novoModo);
                    break;
                case 5:
                    ar.aumentarVelocidade();
                    break;
                case 6:
                    ar.diminuirVelocidade();
                    break;
                case 7:
                    ar.mostrarStatus();
                    break;
                case 0:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
        entrada.close();
    }
}