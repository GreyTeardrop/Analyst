package ru.socionicasys.analyst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;

public class Analyst {
	private static final Logger logger = LoggerFactory.getLogger(Analyst.class);

	public static void main(String[] args) {
		logger.trace("> main()");
		final String startupFilename;
		if (args != null && args.length > 0) {
			startupFilename = args[0];
		} else {
			startupFilename = null;
		}
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				Logger logger = LoggerFactory.getLogger("UncaughtExceptionHandler");
				logger.error("Uncaught exception in thread " + t.toString(), e);
			}
		});
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI(startupFilename);
			}
		});
		logger.trace("< main()");
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event dispatch thread.
	 *
	 * @param startupFilename
	 */
	private static void createAndShowGUI(String startupFilename) {
		//Create and set up the window.
		logger.trace("> createAndShowGUI(), startupFilename={}", startupFilename);
		final AnalystWindow frame = new AnalystWindow(startupFilename);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
		logger.trace("< createAndShowGUI()");
	}
}
