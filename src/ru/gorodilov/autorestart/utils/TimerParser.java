package ru.gorodilov.autorestart.utils;

import ru.gorodilov.autorestart.core.AutoRestart;
import ru.gorodilov.autorestart.objects.HMS;

public class TimerParser {

	public static HMS parseToHMS() {
		int H = AutoRestart.TIMER.TIME / 3600;
		int M = AutoRestart.TIMER.TIME / 60 - H * 60;
		int S = AutoRestart.TIMER.TIME - H * 3600 - M * 60;
		return new HMS(H, M, S);
	}
	
}
