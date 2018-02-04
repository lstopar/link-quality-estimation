/*
	This file contains a sample usage of WEKAClassificationModelBuilder.
*/

import java.util.*;

import weka.classifiers.trees.J48;

/**
 * Test class for running WEKAClassificationModelBuilder.
 */
public class WekaClassificationModelBuilderExample {
	static final String FILENAME = "../dataset-10-JSI_sigfox_20161124.arff";
	static final String OUTFILENAME = "/Users/lstopar/data/cognitive-seminarska/results";
//	static final List<String> UNWANTEDATTRIBUTES =
//		Arrays.asList("prr", "seq", "received", "attenuator", "link_num", "experiment_num", "pga_gain");
	static final List<String> UNWANTEDATTRIBUTES =
			Arrays.asList("dataset_num", "prr", "seq", "received", "attenuator", "link_num", "experiment_num", "pga_gain");


	static final List<Set<String>> ATTRIBUTE_GROUPS = new ArrayList<>();

	static {
	    ATTRIBUTE_GROUPS.add(new HashSet<>(Arrays.asList(new String[] {"rssi-q-10", "rssi-q-20", "rssi-q-30", "rssi-q-40", "rssi-q-50", "rssi-q-60", "rssi-q-70", "rssi-q-80", "rssi-q-90"})));
	}

	/**
	 * Main method for testing WekaClassificationModelBuilder.
	 */
	public static void main(String[] args) throws Exception {
	    String fnameIn = args[0];
	    String fnameOut = args[1];

		WekaClassificationModelBuilder wmb = new WekaClassificationModelBuilder(fnameIn, fnameOut, UNWANTEDATTRIBUTES, ATTRIBUTE_GROUPS);

		wmb.buildAllModels(true, new J48(), 10);
		wmb.listToFile();
	}
}