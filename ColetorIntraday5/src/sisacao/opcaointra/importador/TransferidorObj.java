package sisacao.opcaointra.importador;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;



public class TransferidorObj {
	private final String DIRETORIO_DOWNLOAD = "download";
	private final String URL_PATH = "http://www.bmfbovespa.com.br/bdi/";

	public boolean main(String data, String ano) {
		String diretorioDownload = "D:/CotacaoJava/download/" + ano;
		String diretorioTrabalho = "download";
		String nomeArquivo = "bdi" + data + ".zip";
		File localFile = new File(diretorioDownload + File.separator + nomeArquivo);
		try {
			//URL url = new URL("http://www.bmfbovespa.com.br/bdi/" + nomeArquivo);
			URL url = new URL("http://bvmf.bmfbovespa.com.br/fechamento-pregao/bdi/" + nomeArquivo);
			InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream(localFile);
			copyStream(in, out);
			return unzipFiles(diretorioDownload, nomeArquivo, diretorioTrabalho);
		} catch (Exception e) {
			//ArquivoLog.getInstancia().salvaErro(e);
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean obtemDeArquivo(String data){ 
		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6);
		
		String diretorioDownload = "//DIGICOM-COLETOR/CotacaoSisacao/download/" + ano + "/";
		String nomeArquivo = "bdi" + mes + dia + ".zip";
		File localFile = new File(diretorioDownload + File.separator
				+ nomeArquivo);
		String diretorioTrabalho = "download"; 
				
		try {
			//URL url = new URL("http://www.bmfbovespa.com.br/bdi/" + nomeArquivo);
			//InputStream in = url.openStream();
			//FileOutputStream out = new FileOutputStream(localFile);
			//copyStream(in, out);
			return unzipFiles(diretorioDownload, nomeArquivo, diretorioTrabalho);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean unzipFiles(String srcDirectory, String srcFile,
			String destDirectory) {
		int BUFFER_SIZE = 4096;
		try {
			File sourceDirectory = new File(srcDirectory);
			File sourceFile = new File(srcDirectory + File.separator + srcFile);
			File destinationDirectory = new File(destDirectory);

			if (!sourceDirectory.exists()) {
				System.out.println("Diretório:" + srcDirectory
						+ " não existe");
				return false;
			}
			if (!sourceFile.exists()) {
				System.out.println("Arquivo:" + srcDirectory + File.separator
						+ srcFile + " não existe");
				return false;
			}
			if (!destinationDirectory.exists()) {
				System.out.println("Diretório:" + destDirectory
						+ " não existe");
				return false;
			}

			BufferedOutputStream dest = null;

			FileInputStream fis = new FileInputStream(sourceFile);
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(fis));

			ZipEntry entry = null;

			while ((entry = zis.getNextEntry()) != null) {
				String outputFilename = destDirectory + File.separator
						+ entry.getName();
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

	private void createDirIfNeeded(String destDirectory, ZipEntry entry) {
		String name = entry.getName();
		if (name.contains("/")) {
			int index = name.lastIndexOf("/");
			String dirSequence = name.substring(0, index);
			File newDirs = new File(destDirectory + File.separator
					+ dirSequence);
			newDirs.mkdirs();
		}
	}

	private void copyStream(InputStream in, OutputStream out)
			throws IOException {
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

/*
 * Location: D:\Java-Recuperacao\CotacaoJava2.jar Qualified Name:
 * cotacaojava2.coletordiario.TransferidorObj JD-Core Version: 0.6.0
 */