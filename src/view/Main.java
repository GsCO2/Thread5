package view;

import controller.ThreadPing;

public class Main {
	public static void main(String[] args) {
		String os = System.getProperty("os.name");
		if(!os.contains("Linux")) {
			System.out.println("OS inválido");
			System.exit(0);
		} 
		String[] servidores = new String[3];
		servidores[0] = "www.uol.com.br";
		servidores[1] = "www.terra.com.br";
		servidores[2] = "www.google.com.br";
		for(int i = 0; i < servidores.length; i++) {
			ThreadPing thread = new ThreadPing(servidores[i]);
			thread.start();
		} 
	}
}
