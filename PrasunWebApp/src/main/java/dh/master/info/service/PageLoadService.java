package dh.master.info.service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class PageLoadService {

	public String loadRawFile(String filePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		Scanner s = new Scanner(new File(filePath), "UTF-8");
		while (s.hasNextLine()) {
			sb.append(s.nextLine());
			sb.append("\n");
		}
		s.close();
		return sb.toString();
	}

}
