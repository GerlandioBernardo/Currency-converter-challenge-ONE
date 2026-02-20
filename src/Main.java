package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ExchangeRateService service = new ExchangeRateService();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("**************************************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]\n");

            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("**************************************************************");


            opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Encerrando aplicação...");
                break;
            }
            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            try {

                ExchangeResponse response = null;

                switch (opcao) {
                    case 1:
                        response = service.convert("USD", "ARS", valor);
                        break;

                    case 2:
                        response = service.convert("ARS", "USD", valor);
                        break;

                    case 3:
                        response = service.convert("USD", "BRL", valor);
                        break;

                    case 4:
                        response = service.convert("BRL", "USD", valor);
                        break;

                    case 5:
                        response = service.convert("USD", "COP", valor);
                        break;

                    case 6:
                        response = service.convert("COP", "USD", valor);
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        continue;
                }

                // Mostra resultado
                System.out.println("Valor " + valor + " [" + response.getBaseCode()+ "] "
                        + "corresponde ao valor final de =>> " +
                        response.getConversionResult() + " [" + response.getTargetCode() + "]");

            } catch (Exception e) {
                System.out.println("Erro ao converter moeda: " + e.getMessage());
            }

        } while (opcao != 0);

        scanner.close();
    }
}
