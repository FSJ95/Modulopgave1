import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DataSanitering {

	public static void main(String[] args)
	throws FileNotFoundException, IOException {
		new DataSanitering().transposeData1("tilInput.tsv","tilOutput.csv");
		new DataSanitering().transposeData1("fraInput.tsv","fraOutput.csv");
		new DataSanitering().transposeData2("bevInput.tsv","bevOutput.csv");
	}
	
	public static void transposeData1(String inputFile, String outputFile)
	throws FileNotFoundException, IOException {
		Scanner scan = new Scanner(new File(inputFile));
		FileWriter output = new FileWriter(outputFile,false);

		boolean firstLine = true;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] tokens = line.split("\t");
			String columns = "";
			String delimiter = ",";
			
			for (int k=0;k<4;k++) {
				columns = columns + tokens[k] + delimiter;
			}
			if (firstLine) {
				output.write(columns + "aar" + delimiter + "antal" + "\r\n");
				firstLine = !firstLine;
			}
			else {
				for (int i=2006; i<2018; i++) {
					output.write(columns + i + delimiter + tokens[i-2002] + "\r\n");
				}
			}
		}
		output.flush();
		output.close();
	}
	
	public static void transposeData2(String inputFile, String outputFile)
	throws FileNotFoundException, IOException {
		Scanner scan = new Scanner(new File(inputFile));
		FileWriter output = new FileWriter(outputFile,false);

		boolean firstLine = true;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] tokens = line.split("\t");
			String columns = "";
			String delimiter = ",";
			
			for (int k=0;k<3;k++) {
				columns = columns + tokens[k] + delimiter;
			}
			if (firstLine) {
				output.write(columns + "aar" + delimiter + "antal" + "\r\n");
				firstLine = !firstLine;
			}
			else {
				for (int i=2006; i<2018; i++) {
					output.write(columns + i + delimiter + tokens[i-2003] + "\r\n");
				}
			}
		}
		output.flush();
		output.close();
	}
}