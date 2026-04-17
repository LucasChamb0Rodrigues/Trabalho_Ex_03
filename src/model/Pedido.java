package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Pedido {
    private static int contadorId = 1;
    private int id;
    private List<Produto> itens = new ArrayList<>();
    private LocalDate data;
    private boolean finalizado = false;

    public Pedido() {
        this.id = contadorId++;
        this.data = LocalDate.now();
    }

    public void adicionarProduto(Produto p) {
        itens.add(p);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(Produto::getPreco).sum();
    }

    public void finalizarPedido() {
        if (itens.isEmpty()) {
            throw new IllegalStateException("Não é possível finalizar um pedido sem produtos.");
        }
        this.finalizado = true;
    }

    public int getId() { return id; }
    public LocalDate getData() { return data; }
    public List<Produto> getItens() { return itens; }

    @Override
    public String toString() {
        return "model.Pedido #" + id + " | Itens: " + itens.size() + " | Total: R$ " + calcularTotal();
    }
}