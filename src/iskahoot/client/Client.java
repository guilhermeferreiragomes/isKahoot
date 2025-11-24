package iskahoot.client;

import iskahoot.client.gui.View;

public class Client {
    public static void main(String[] args) {
        // Validar argumentos
        if (args.length != 5) {
            System.err.println("Uso: java Client <IP> <PORT> <Jogo> <Equipa> <Username>");
            System.err.println("   Exemplo: java Client localhost 8080 \"Game Zero\" \"Team1\" \"Player11\"");
            System.exit(1);
        }
        
        String ip = args[0];
        int port;
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Porto inválido: " + args[1]);
            System.exit(1);
            return;
        }
        
        String jogo = args[2];
        String equipa = args[3];
        String username = args[4];
        
        System.out.println("Cliente Kahoot");
        System.out.println("   IP: " + ip);
        System.out.println("   Porto: " + port);
        System.out.println("   Jogo: " + jogo);
        System.out.println("   Equipa: " + equipa);
        System.out.println("   Username: " + username);
        System.out.println("--------------------------------------");
        
        // Criar e conectar ClientNetwork
        ClientNetwork network = new ClientNetwork(ip, port, jogo, equipa, username);
        
        if (network.connect()) {
            // Só mostrar interface se conexão bem-sucedida
            System.out.println("A iniciar interface...");
            View mainView = new View();
            mainView.setVisible(true);
            
            // TODO: Conectar interface com network
            // mainView.setClientNetwork(network);
            
        } else {
            System.err.println("Falha ao conectar. A sair...");
            System.exit(1);
        }
    }
}