package ru.gorodilov.autorestart.utils.config.private_messages;

import ru.gorodilov.autorestart.utils.config.Config;
import ru.gorodilov.autorestart.utils.config.private_messages.enabled.Status;

public class Enabled {

	public Boolean TIME() {
		return Config.PRIVATE_MESSAGES.getBoolean(Config.getNode(), true);
	}

	public Status STATUS = new Status();
	
	public Boolean CHANGE() {
		return Config.PRIVATE_MESSAGES.getBoolean(Config.getNode(), true);
	}

	public Boolean PAUSE_REMINDER() {
		return Config.PRIVATE_MESSAGES.getBoolean(Config.getNode(), true);
	}

}
