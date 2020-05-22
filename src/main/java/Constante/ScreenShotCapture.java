package Constante;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class ScreenShotCapture {
	
	/**
	 * Método de gerar o screenshot e salvar em um diretório
	 */
	public static void screenShot() {

		double screenH = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		double screenW = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		Date data = new Date();
		SimpleDateFormat formatSimple = new SimpleDateFormat("ddMMyyyyHHmmss");

		try {

			Robot robot = new Robot();
			BufferedImage screen = robot.createScreenCapture(new Rectangle((int) screenW, (int) screenH));

			ImageIO.write(screen, "jpg",
					new File("target/Evidencias/" + formatSimple.format(data) + ".jpg"));

		} catch (Exception e) {

		}

	}

	/**
	 * Gerador de arquivos em pdf, assim como adicionar todas as fotos no pdf.
	 * 
	 * @throws Exception
	 */
	public static void arquivosDir() throws Exception {

		Document documento = new Document();

		// Ler o diretório existente
		File file = new File("target/Evidencias/");

		// Listar os arquivos
		File array[] = file.listFiles();

		// Criar o pdf
		PdfWriter.getInstance(documento,
				new FileOutputStream("target/Evidencias/ArquivoDeEvidencia.pdf"));

		// Abrir o pdf
		documento.open();

		for (File i : array) {
			if (i.getName().endsWith(".jpg")) {

				Image img = Image.getInstance("target/Evidencias/" + i.getName());

				img.setAlignment(Element.ALIGN_CENTER);
				img.scaleToFit(350f, 350f);
				documento.add(img);

				// Criar uma nova página.
				documento.newPage();
			}

		}

		// Fechar o PDF
		documento.close();

	}

}
