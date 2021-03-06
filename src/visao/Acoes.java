package visao;

import controle.ControladorAgenda;
import modelo.Contato;

import java.util.Scanner;

public class Acoes {
    private static Scanner scanner = new Scanner(System.in);
    private static ControladorAgenda controlador = new ControladorAgenda();

    private static void listarTodosOsContatos(){
        System.out.println("Todos os contatos: ");
        for (Contato i : controlador.obterContatos()){
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=");
            System.out.printf("ID: %d\nNome: %s\n", i.getId(), i.getNome(), i.getTelefone(), i.getEmail());
        }
    }
    public static void adicionarContato(){
        String nome;
        String telefone;
        String email;

        System.out.print("Digite o nome: ");
        nome = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        telefone = scanner.nextLine();

        System.out.print("Digite o email: ");
        email = scanner.nextLine();

        if (controlador.cadastrarContato(nome, telefone, email)){
            System.out.println("Contato adicionado com sucesso!");
        }
        else {
            System.out.println("Falha em adicionar contato!");
        }
    }
    public static void removerContato(){
        listarTodosOsContatos();
        System.out.print("Digite o ID, do contato que você quer remover: ");
        try {
            int idDeletar = Integer.parseInt(scanner.nextLine());
            Contato c = controlador.acharContato(idDeletar);
            if (controlador.removerContato(c)) {
                System.out.println("Contato removido com sucesso!");
            } else {
                System.out.println("Falha ao remover contato!");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Digite apenas números!");
        }
    }
    public static void atualizarContato(){
        String novoNome;
        String novoTelefone;
        String novoEmail;
        listarTodosOsContatos();
        System.out.print("Digite o ID, do contato que você deseja alterar: ");
        try {
            int idAlterar = Integer.parseInt(scanner.nextLine());

            Contato contatoNovo = new Contato();

            contatoNovo.setId(idAlterar);
            System.out.print("Digite o novo nome: ");
            novoNome = scanner.nextLine();

            System.out.print("Digite o novo telefone: ");
            novoTelefone = scanner.nextLine();

            System.out.print("Digite o novo email: ");
            novoEmail = scanner.nextLine();

            if (controlador.atualizarContato(idAlterar, novoNome, novoTelefone, novoEmail)) {
                System.out.println("Contato alterado com sucesso!");
            } else {
                System.out.println("Falha em alterar o contato.");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Digite apenas números!");
        }
    }
    public static void listarTodosOsContatosCadastrados(){
        for (Contato i : controlador.obterContatos()){
            if (i != null) {
                System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=");
                System.out.printf("ID: %d\nNome: %s\nTelefone: %s\nEmail: %s\n", i.getId(), i.getNome(), i.getTelefone(), i.getEmail());
            }
            else {
                System.out.println("Nenhum contato cadastrado.");
            }
        }
    }
    public static void getContato(){
        System.out.print("Digite o ID do contato, que você deseja obter mais informações: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Contato contatoSelecionado = controlador.acharContato(id);
            if (contatoSelecionado != null){
                System.out.println("Nome: " + contatoSelecionado.getNome());
                System.out.println("Telefone: " + contatoSelecionado.getTelefone());
                System.out.println("Email: " + contatoSelecionado.getEmail());
            }
            else{
                System.out.println("Contato não encontrado!");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Digite apenas números!");
        }

    }
}
