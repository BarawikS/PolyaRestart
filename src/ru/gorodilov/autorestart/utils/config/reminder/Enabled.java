package ru.gorodilov.autorestart.utils.config.reminder;

import ru.gorodilov.autorestart.utils.config.Config;

public class Enabled {

	public Boolean MINUTES() {
		return Config.REMINDER.getBoolean(Config.getNode(), true);
	}

	public Boolean SECONDS() {
		return Config.REMINDER.getBoolean(Config.getNode(), true);
	}
	
}
