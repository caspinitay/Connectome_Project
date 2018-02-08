package nets150.cis.upenn.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Connectome {
	private float[][] connectivity;
	private String filename;
	
	public Connectome(String filename) {
		this.filename = filename;
		readFile();
	}
	
	public Connectome(float[][] connectivity, String filename) {
		this.filename = filename;
		this.connectivity = connectivity;
	}
	
	private void readFile() {
		try {
			Scanner in = new Scanner(new File(filename));
			
			connectivity = new float[264][264];
			int row = 0;
			float total = 0;
			while (in.hasNextLine()) {
				String nextRow = in.nextLine().trim();
				String[] words = nextRow.split("\\s+");
				
				for (int i = 0; i < 264; i++) {
					String word = words[i];
					if (word.equals("Inf")) {
						connectivity[row][i] = 0;
					} else {
						connectivity[row][i] = Float.valueOf(word);
						total += connectivity[row][i];
					}
					//System.out.println(connectivity[row][i]);
				}
				
				row++;
			}
			float averageWeight = total / (264 * 264);
			float standardDeviation = 0;
			
			for (int j = 0; j < 264; j++) {
				for (int i = 0; i < 264; i++) {
					float rowError = connectivity[j][i] - averageWeight;
					standardDeviation += (rowError * rowError);
				}
			}
			standardDeviation = (float) Math.sqrt(standardDeviation)/264;
			
			float threshold = (float) 0.47 * standardDeviation - averageWeight;
			
			for (int i = 0; i < 264; i++) {
				for (int j = 0; j < 264; j++) {
					if (connectivity[i][j] < threshold || connectivity[i][j] < 0) {
						connectivity[i][j] = 0;
					}
				}
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getFilename() {
		return filename;
	}
	
	public float[][] getConnectivity() {
		return connectivity;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Connectome.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Connectome other = (Connectome) obj;
	    return other.getFilename().equals(filename);
	}

	
	
	
	

}
