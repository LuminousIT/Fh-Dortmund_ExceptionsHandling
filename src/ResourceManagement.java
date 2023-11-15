
/**
 * Resource management in Java is done using try-with-resources. This guarantee
 * that objects such as network requests, database connections and references to
 * files are cleanly terminated or closed after use inorder to prevent memory
 * leaks, and trigger avoidable garbage collection routines
 **/

public class ResourceManagement {
	public static void writeToFileZipFileContents(String zipFileName, String outputFileName)
			throws java.io.IOException {

		java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
		java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

		// Open zip file and create output file with
		// try-with-resources statement

		try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
				java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {
			// Enumerate each entry
			for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				String zipEntryName = ((java.util.zip.ZipEntry) entries.nextElement()).getName() + newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		}
	}
}

/**
 * In this example, the try-with-resources statement contains two declarations that are separated by a 
 * semicolon: ZipFile and BufferedWriter. When the block of code that directly follows it terminates, 
 * either normally or because of an exception, the close methods of the BufferedWriter and ZipFile objects 
 * are automatically called in this order. Note that the close methods of resources are called 
 * in the opposite order of their creation.
 * **/
