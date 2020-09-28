package br.com.nick;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GravarArquivo {
	public void gravarArquivo(String linha) {
		Path dir = Paths.get("resultado.txt");
		if(Files.notExists(dir, LinkOption.NOFOLLOW_LINKS)) {
			
			try {
				//Files.createDirectories(dir);
				Files.createFile(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Files.write(dir, linha.getBytes());
		} catch (IOException e) {
			System.out.println("Não foi possivel escrever arquivo");
		}
		
	}
}
