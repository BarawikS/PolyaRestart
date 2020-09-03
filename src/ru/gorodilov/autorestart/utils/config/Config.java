package ru.gorodilov.autorestart.utils.config;

public class Config {

	public static Main MAIN = new Main();
	public static Reminder REMINDER = new Reminder();
	public static GlobalBroadcast GLOBAL_BROADCAST = new GlobalBroadcast();
	public static PrivateMessages PRIVATE_MESSAGES = new PrivateMessages();
	public static Commands COMMANDS = new Commands();
	public static MaxPlayers MAX_PLAYERS = new MaxPlayers();
    
	public static String getNode() {
		String directory = Thread.currentThread().getStackTrace()[2].getClassName().toLowerCase().replaceAll("ru.gorodilov.autorestart.utils.config.", "");
		String method = Thread.currentThread().getStackTrace()[2].getMethodName().toLowerCase();
		return directory + "." + method;
	}
	
}
