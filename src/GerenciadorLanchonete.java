import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GerenciadorLanchonete {
    private List<Pedido> historicoPedidos = new ArrayList<>();

    public void registrarPedido(Pedido p) {
        p.finalizarPedido();
        historicoPedidos.add(p);
        System.out.println("Pedido #" + p.getId() + " registrado e finalizado!");
    }

    public void consultarFaturamentoPorData(LocalDate data) {
        double total = 0;
        System.out.println("\n--- Pedidos do dia " + data + " ---");
        for (Pedido p : historicoPedidos) {
            if (p.getData().equals(data)) {
                System.out.println(p);
                total += p.calcularTotal();
            }
        }
        System.out.println("Faturamento Total no Dia: R$ " + total);
    }
}