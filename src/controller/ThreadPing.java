package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadPing extends Thread{
	String comando = "ping -4 -c 10 ";
	String servidor;
	public ThreadPing(String servidor) {
		this.servidor = servidor;
	}
	public void run() {
		String proc = comando + servidor;
		String[] procarr = proc.split(" ");
		try {
			Process p = Runtime.getRuntime().exec(procarr);
			InputStream flow = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String linha;
			String temp;
			String nomeserv = servidor.split("\\.")[1];
			String avg;
			while((linha = buffer.readLine()) != null) {
				if(linha.contains("time")) {
					temp = linha.split(" ")[6];
					System.out.println("Ping do servidor " + nomeserv + " ==> " + temp + ".ms");
				} else if(linha.contains("avg")) {
					avg = linha.split("/")[4];
					System.out.println("Média do ping do servidor " + nomeserv + " ==> " + avg + ".ms");
				}
			}
			reader.close();
			buffer.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
