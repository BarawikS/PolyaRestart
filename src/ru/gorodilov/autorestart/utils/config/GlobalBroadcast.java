package ru.gorodilov.autorestart.utils.config;

import ru.gorodilov.autorestart.objects.ConfigFile;
import ru.gorodilov.autorestart.utils.config.global_broadcast.Enabled;
import ru.gorodilov.autorestart.utils.config.global_broadcast.Messages;

public class GlobalBroadcast extends ConfigFile {

	public Enabled ENABLED = new Enabled();
	
	public Messages MESSAGES = new Messages();
	
}
