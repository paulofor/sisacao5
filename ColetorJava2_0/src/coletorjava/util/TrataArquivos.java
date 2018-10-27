package coletorjava.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TrataArquivos {

	public static void unzipFiles(String fonte, String destino) throws IOException {
		int BUFFER_SIZE = 4096;

		File arqFonte = new File(fonte);
		// File sourceFile = new File(srcDirectory + File.separator + srcFile);
		File arqDesstino = new File(destino);

		/*
		 * if (!sourceDirectory.exists()) { System.out.println("Diretório:" +
		 * srcDirectory + " não existe"); return false; } if
		 * (!sourceFile.exists()) { System.out.println("Arquivo:" + srcDirectory
		 * + File.separator + srcFile + " não existe"); return false; } if
		 * (!destinationDirectory.exists()) { System.out.println("Diretório:" +
		 * destDirectory + " não existe"); return false; }
		 */

		BufferedOutputStream dest = null;

		FileInputStream fis = new FileInputStream(arqFonte);
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));

		ZipEntry entry = null;

		while ((entry = zis.getNextEntry()) != null) {
			String outputFilename = destino;
			System.out.println("Extracting file: " + fonte);
			// createDirIfNeeded(destDirectory, entry);

			byte[] data = new byte[BUFFER_SIZE];
			FileOutputStream fos = new FileOutputStream(outputFilename);
			dest = new BufferedOutputStream(fos, BUFFER_SIZE);
			int count;
			while ((count = zis.read(data, 0, BUFFER_SIZE)) != -1) {
				dest.write(data, 0, count);
			}
			dest.flush();
			dest.close();
		}
		zis.close();

	}

	public static boolean unzipFiles(String srcDirectory, String srcFile, String destDirectory) {
		int BUFFER_SIZE = 4096;
		try {
			File sourceDirectory = new File(srcDirectory);
			File sourceFile = new File(srcDirectory + File.separator + srcFile);
			File destinationDirectory = new File(destDirectory);

			if (!sourceDirectory.exists()) {
				System.out.println("Diretório:" + srcDirectory + " não existe");
				return false;
			}
			if (!sourceFile.exists()) {
				System.out.println("Arquivo:" + srcDirectory + File.separator + srcFile + " não existe");
				return false;
			}
			if (!destinationDirectory.exists()) {
				System.out.println("Diretório:" + destDirectory + " não existe");
				return false;
			}

			BufferedOutputStream dest = null;

			FileInputStream fis = new FileInputStream(sourceFile);
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));

			ZipEntry entry = null;

			while ((entry = zis.getNextEntry()) != null) {
				String outputFilename = destDirectory + File.separator + entry.getName();
				System.out.println("Extracting file: " + entry.getName());
				createDirIfNeeded(destDirectory, entry);

				byte[] data = new byte[BUFFER_SIZE];
				FileOutputStream fos = new FileOutputStream(outputFilename);
				dest = new BufferedOutputStream(fos, BUFFER_SIZE);
				int count;
				while ((count = zis.read(data, 0, BUFFER_SIZE)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private static void createDirIfNeeded(String destDirectory, ZipEntry entry) {
		String name = entry.getName();
		if (name.contains("/")) {
			int index = name.lastIndexOf("/");
			String dirSequence = name.substring(0, index);
			File newDirs = new File(destDirectory + File.separator + dirSequence);
			newDirs.mkdirs();
		}
	}

	private static void copyStream(InputStream in, OutputStream out) throws IOException {
		int BUFFER_SIZE = 4096;
		try {
			byte[] buf = new byte[BUFFER_SIZE];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}
	}
}
