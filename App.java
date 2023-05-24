
import javax.swing.JOptionPane;
import java.util.*;

public class App {
  public static void main(String[] args) throws Exception {

    Cliente cliente = new Cliente();

    ArrayList<String> cadastro = new ArrayList<String>();

    int escolha;
    char resp = 'n';
    while (resp == 'n' || resp == 'N') {

      JOptionPane.showMessageDialog(null, "Bem vindo, escolha uma ação");
      escolha = Integer.parseInt(
          JOptionPane.showInputDialog(null, "Menu principal"
              + "\n\n 1 - Agendar corte"
              + "\n  2 - Agendar barba"
              + "\n  3 - Agendar sobrancelha"
              + "\n  4 - Ver cadastrados "
              + "\n  5 - Deletar cadastro"
              + "\n  6 - Atualizar cadastro"
              + "\n  7 - Sair"));

      switch (escolha) {
        // AGENDAR CORTE:
        case 1:
          Corte corte = new Corte();

          String nome = JOptionPane.showInputDialog("Digite o seu nome");
          cliente.setNomeCliente(nome);

          int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira sua idade: "));
          cliente.setIdadeCliente(idade);

          String telefone = JOptionPane.showInputDialog(null, "Digite o seu telefone");
          cliente.setTelefoneCliente(telefone);

          int medidaCabelo;
          do {

            medidaCabelo = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Qual é o tamanho do seu cabelo? "
                    + "\n\n 1 - Curto"
                    + "\n   2 - Médio"
                    + "\n   3 - Longo"));

          } while (medidaCabelo != 1 && medidaCabelo != 2 && medidaCabelo != 3);

          switch (medidaCabelo) {
            case 1:
              corte.setTamanhoCabelo("curto");

              break;

            case 2:
              corte.setTamanhoCabelo("medio");
              break;

            case 3:
              corte.setTamanhoCabelo("longo");
              break;

            default:
              JOptionPane.showInputDialog(null, "Digite uma opção valida");
              break;
          }

          corte.dataServico();
          corte.calculaTempoServico(corte.getTamanhoCabelo());
          corte.adicionaServico();

          JOptionPane.showMessageDialog(null, "" + cliente + corte);

          cadastro.add("" + cliente + corte);

          JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
          break;

        // AGENDAR BARBA:
        case 2:
          Barba barba = new Barba();

          nome = JOptionPane.showInputDialog("Digite o seu nome");
          cliente.setNomeCliente(nome);

          idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira sua idade: "));
          cliente.setIdadeCliente(idade);

          telefone = JOptionPane.showInputDialog(null, "Digite o seu telefone");
          cliente.setTelefoneCliente(telefone);

          int escolhaBarba;
          do {
            escolhaBarba = Integer.parseInt(JOptionPane.showInputDialog(null, "Como será o tratamento com a sua barba?"

                + "\n\n 1 - simples, apenas corte e alinhamento. (20 reais)"
                + "\n  2 - completo, com massagem e toalha quente. (50 reais)"));

          } while (escolhaBarba != 1 && escolhaBarba != 2);

          switch (escolhaBarba) {
            case 1:
              barba.setTipoTratamentoBarba("simples");
              break;

            case 2:
              barba.setTipoTratamentoBarba("completo");

              break;

            default:
              JOptionPane.showInputDialog(null, "Digite uma opção valida");
              break;
          }

          barba.dataServico();
          barba.calculaTempoServico(barba.getTipoTratamentoBarba());
          barba.adicionaServico();

          JOptionPane.showMessageDialog(null, "" + cliente + barba);

          cadastro.add("" + cliente + barba);

          JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
          break;

        // AGENDAR SOBRANCELHA:
        case 3:
          Sobrancelha sobrancelha = new Sobrancelha();

          nome = JOptionPane.showInputDialog("Digite o seu nome");
          cliente.setNomeCliente(nome);

          idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira sua idade: "));
          cliente.setIdadeCliente(idade);

          telefone = JOptionPane.showInputDialog(null, "Digite o seu telefone");
          cliente.setTelefoneCliente(telefone);

          int escolhaSobrancelha;
          do {
            escolhaSobrancelha = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Como será o procedimento com a sua sobrancelha?"

                    + "\n\n 1 - Realizar procedimento com pinça"
                    + "\n  2 - Realizar procedimento com navalha"));

          } while (escolhaSobrancelha != 1 && escolhaSobrancelha != 2);

          switch (escolhaSobrancelha) {
            case 1:
              sobrancelha.setProcedimento("pinça");
              break;

            case 2:
              sobrancelha.setProcedimento("navalha");

              break;

            default:
              JOptionPane.showInputDialog(null, "Digite uma opção valida");
              break;
          }

          sobrancelha.dataServico();
          sobrancelha.calculaTempoServico(sobrancelha.getProcedimento());
          sobrancelha.adicionaServico();

          JOptionPane.showMessageDialog(null,
              "" + cliente + sobrancelha);

          cadastro.add("" + cliente + sobrancelha);

          JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
          break;

        // VER CADASTRADOS:
        case 4:
          /* Validação para caso ainda não haver cadastro */
          if (cadastro.size() == 0) {

            JOptionPane.showMessageDialog(null, "Ainda não há cliente cadastrado");
          } else {

            for (int i = 0; i < cadastro.size(); i++) {
              JOptionPane.showMessageDialog(null, "Número de identificação - " + (i) + "\n\n" + cadastro.get(i));
            }
          }
          break;

        // DELETAR CADASTRO:
        case 5:
          /* Validação para caso ainda não haver cadastro */
          if (cadastro.size() == 0) {

            JOptionPane.showMessageDialog(null, "Primeiro cadastre um cliente");

          } else {

            /* Mostra clientes cadastrados para usuário poder escolher qual irá deletar */
            JOptionPane.showMessageDialog(null,
                "Atenção ao 'Número de identificação do cliente', pois será solicitado para deletar cadastro");
            JOptionPane.showMessageDialog(null, "Clientes cadastrados: ");
            for (int i = 0; i < cadastro.size(); i++) {
              JOptionPane.showMessageDialog(null, "Número de identificação - " + (i) + "\n\n" + cadastro.get(i));
            }

            int elimineCliente = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Digite o número de identificação do cliente que deseja deletar"));

            // validação para caso o numero de identificação não exista na lista
            if (elimineCliente >= 0 && elimineCliente < cadastro.size()) {

              cadastro.remove(elimineCliente);
              JOptionPane.showMessageDialog(null, "Cadastro removido com sucesso");

            } else {

              JOptionPane.showMessageDialog(null, "Ops!! algo deu errado");

            }

          }
          break;

        // ATUALIZAR DADOS:
        case 6:
          Corte c2 = new Corte();
          Barba b2 = new Barba();
          Sobrancelha s2 = new Sobrancelha();

          /* Validação para caso ainda não haver cadastro */
          if (cadastro.size() == 0) {

            JOptionPane.showMessageDialog(null, "primeiro cadastre um cliente");

          } else {

            JOptionPane.showMessageDialog(null, "Clientes cadastrados: ");

            // Mostra os clientes cadastrados:
            for (int i = 0; i < cadastro.size(); i++) {
              JOptionPane.showMessageDialog(null, "Número de identificação - " + (i) + "\n\n" + cadastro.get(i));
            }

            int atualizaCliente = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Digite o número de identificação do cliente que deseja atualizar"));

            // validação para caso o numero de identificação não exista na lista
            if (atualizaCliente >= 0 && atualizaCliente < cadastro.size()) {

              int escolhaModificar = Integer.parseInt(JOptionPane.showInputDialog(null,
                  "O que deseja mudar no cadastro?" +
                      "\n\n 1 - Nome"
                      + "\n 2 - Idade"
                      + "\n 3 - Telefone "));

              switch (escolhaModificar) {

                case 1:
                  String novoNome = JOptionPane.showInputDialog(null, "Digite um novo nome");
                  cliente.setNomeCliente(novoNome);
                  cadastro.set(atualizaCliente, "" + cliente);
                  break;

                case 2:
                  int novaIdade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma nova idade"));
                  cliente.setIdadeCliente(novaIdade);
                  cadastro.set(atualizaCliente, "" + cliente);
                  break;

                case 3:
                  String novoTelefone = JOptionPane.showInputDialog(null, "Digite um novo telefone");
                  cliente.setTelefoneCliente(novoTelefone);
                  cadastro.set(atualizaCliente, "" + cliente);
                  break;

                default:
                  JOptionPane.showMessageDialog(null, "Ops!! algo deu errado");
                  break;
              }

              int escolhaServico = Integer.parseInt(JOptionPane.showInputDialog(null,
                  "Escolha para qual serviço irá atualizar esse cliente"
                      + "\n\n 1 - Corte"
                      + "\n  2 - Barba"
                      + "\n  3 - Sobrancelha"));

              switch (escolhaServico) {
                case 1:
                  int novaMedidaCabelo;
                  do {

                    novaMedidaCabelo = Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Qual é o tamanho do seu cabelo? "
                            + "\n\n 1 - Curto"
                            + "\n   2 - Médio"
                            + "\n   3 - Longo"));

                  } while (novaMedidaCabelo != 1 && novaMedidaCabelo != 2 && novaMedidaCabelo != 3);

                  switch (novaMedidaCabelo) {
                    case 1:
                      c2.setTamanhoCabelo("curto");

                      break;

                    case 2:
                      c2.setTamanhoCabelo("medio");
                      break;

                    case 3:
                      c2.setTamanhoCabelo("longo");
                      break;

                    default:
                      JOptionPane.showInputDialog(null, "Digite uma opção valida");
                      break;
                  }
                  c2.calculaTempoServico(c2.getTamanhoCabelo());
                  c2.adicionaServico();
                  c2.dataServico();
                  cadastro.set(atualizaCliente, "" + cliente + c2);
                  JOptionPane.showMessageDialog(null, "Novo cadastro");

                  JOptionPane.showMessageDialog(null, "Número de identificação - " + (atualizaCliente) + "\n\n"
                      + cadastro.get(atualizaCliente));

                  break;

                case 2:

                  int escolhaNovaBarba;
                  do {
                    escolhaNovaBarba = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Como será o tratamento com a sua barba?"

                            + "\n\n 1 - simples, apenas corte e alinhamento. (20 reais)"
                            + "\n  2 - completo, com massagem e toalha quente. (50 reais)"));

                  } while (escolhaNovaBarba != 1 && escolhaNovaBarba != 2);

                  switch (escolhaNovaBarba) {
                    case 1:
                      b2.setTipoTratamentoBarba("simples");
                      break;

                    case 2:
                      b2.setTipoTratamentoBarba("completo");
                      break;

                    default:
                      JOptionPane.showInputDialog(null, "Digite uma opção valida");
                      break;
                  }
                  b2.calculaTempoServico(b2.getTipoTratamentoBarba());
                  b2.adicionaServico();
                  b2.dataServico();
                  cadastro.set(atualizaCliente, "" + cliente + b2);
                  JOptionPane.showMessageDialog(null, "Novo cadastro");

                  JOptionPane.showMessageDialog(null, "Número de identificação - " + (atualizaCliente) + "\n\n"
                      + cadastro.get(atualizaCliente));
                  break;
                case 3:
                  int escolhaNovaSobrancelha;
                  do {
                    escolhaNovaSobrancelha = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Como será o tratamento com a sua barba?"

                            + "\n\n 1 - Realizar procedimento com pinça"
                            + "\n  2 - Realizar procedimento com navalha"));

                  } while (escolhaNovaSobrancelha != 1 && escolhaNovaSobrancelha != 2);

                  switch (escolhaNovaSobrancelha) {
                    case 1:
                      s2.setProcedimento("pinça");
                      break;

                    case 2:
                      s2.setProcedimento("navalha");

                      break;

                    default:
                      JOptionPane.showInputDialog(null, "Digite uma opção valida");
                      break;
                  }

                  s2.calculaTempoServico(s2.getProcedimento());
                  s2.adicionaServico();
                  s2.dataServico();
                  cadastro.set(atualizaCliente, "" + cliente + s2);
                  JOptionPane.showMessageDialog(null, "Novo cadastro");

                  JOptionPane.showMessageDialog(null, "Número de identificação - " + (atualizaCliente) + "\n\n"
                      + cadastro.get(atualizaCliente));
                default:
                  break;
              }

            } else {
              JOptionPane.showMessageDialog(null, "Ops!! algo deu errado");
            }

          }
          break;

        // SAIR:
        case 7:
          do {
            resp = JOptionPane.showInputDialog("Realmente deseja sair? (S/N)").charAt(0);

          } while (resp != 'n' && resp != 'N' && resp != 's' && resp != 'S');
          break;

        default:
          JOptionPane.showMessageDialog(null, "Opção invalida, tente novamente");
          break;
      }
    }
  }
}
