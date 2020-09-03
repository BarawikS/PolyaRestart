package ru.gorodilov.autorestart.utils.config.private_messages.enabled;

import ru.gorodilov.autorestart.utils.config.Config;

public class Status {

	public Boolean START() {
		return Config.PRIVATE_MESSAGES.getBoolean(Config.getNode(), true);
	}

	public Boolean PAUSE() {
		return Config.PRIVATE_MESSAGES.getBoolean(Config.getNode(), true);
	}
	
}
