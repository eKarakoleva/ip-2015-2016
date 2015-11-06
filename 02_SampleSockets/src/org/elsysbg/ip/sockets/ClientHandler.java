package org.elsysbg.ip.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
	private static final String COMMAND_STOP_SERVER = "stopServer";

	private final Socket socket;

	private final EchoServer echoServer;

	public ClientHandler(EchoServer echoServer, Socket socket) {
		this.socket = socket;
		this.echoServer = echoServer;
	}
	
	public void run() {
		try {
			final PrintStream out = 
				new PrintStream(socket.getOutputStream());
			final Scanner scanner =
				new Scanner(socket.getInputStream());
			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				if (COMMAND_STOP_SERVER.equals(line)) {
					echoServer.stopServer();
					break;
				}
				out.println(line);
			}
			scanner.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
