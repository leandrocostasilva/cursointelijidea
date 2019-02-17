package br.com.alura.bytebank.registrador;

import br.com.alura.bytebank.model.Pagamento;
import br.com.alura.bytebank.model.Tipo;

import java.util.ArrayList;
import java.util.List;

public class RegistroDePagamento {

    private final static List<Pagamento> PAGAMENTOS = new ArrayList<>();

    public void registra(List<Pagamento> pagamentos) {
        for (int i = 0; i < pagamentos.size(); i++) {
            Pagamento p = pagamentos.get(i);
            verificaTipo(p);
        }
        exibeEfetuados();
    }

    private void exibeEfetuados() {
        if (!PAGAMENTOS.isEmpty()) {
            System.out.println("Todos os pagamentos");
            for (int i = 0; i < PAGAMENTOS.size(); i++) {
                System.out.println(PAGAMENTOS.get(i));
            }
        } else {
            System.out.println("Não temos pagamentos");
        }
    }

    private void verificaTipo(Pagamento pagamento) {
        if (pagamento.getTipo().equals(Tipo.CREDITO)) {
            pagamento.setValor(pagamento.getValor() * 1.02);
        }
        if (pagamento.getTipo().equals(Tipo.DEBITO)) {
            pagamento.setValor(pagamento.getValor() * 1.001);
        }
        salva(pagamento);
    }

    private void salva(Pagamento pagamento) {
        PAGAMENTOS.add(pagamento);
        System.out.println("Pagamento realizado " + pagamento);
    }

}
