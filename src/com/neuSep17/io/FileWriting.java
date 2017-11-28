package com.neuSep17.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
	private BufferedWriter bufferedWriter;
	public FileWriting(File file, boolean append) throws IOException {
		bufferedWriter = new BufferedWriter(new FileWriter(file, append));
	}
	public BufferedWriter getBufferedWriter() {
		return bufferedWriter;
	}

}
