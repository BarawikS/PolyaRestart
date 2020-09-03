package ru.gorodilov.autorestart.utils.config;

import ru.gorodilov.autorestart.objects.ConfigFile;
import ru.gorodilov.autorestart.utils.config.private_messages.Enabled;
import ru.gorodilov.autorestart.utils.config.private_messages.Messages;

public class PrivateMessages extends ConfigFile {

	public Enabled ENABLED = new Enabled();
	
	public Messages MESSAGES = new Messages();
	
}
