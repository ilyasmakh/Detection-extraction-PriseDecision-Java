package Makhloul.ilyas;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PDFDownloader {
    public static void main(String[] args) {
        //version 1
        getFile("15-79358" ,  "2015" , null,"BOAMP-J-AO_2015_146008") ;
        // version 2
        getFile("25-26618" ,  "2025" , "03","25-26618") ;
    }

    public static void getFile(String idweb , String annee , String mois, String fileName){

       String fileURL= "" ;
        if(fileName.equals(idweb)){
            // https://www.boamp.fr/telechargements/FILES/PDF/2025/03/25-26618.pdf
            fileURL = "https://www.boamp.fr/telechargements/FILES/PDF/"+annee+"/"+mois+"/"+idweb+".pdf";
        }
        else {
         //   https://www.boamp.fr/telechargements/PDF/2015/BOAMP-J-AO_2015_146008/15-79358.pdf
            fileURL = "https://www.boamp.fr/telechargements/PDF/"+annee+"/"+fileName+"/"+idweb+".pdf";
        }

        String savePath = "C:/Users/pc/Downloads/"+idweb+".pdf"; // Modifier selon ton système

        try {
            downloadFile(fileURL, savePath);
            System.out.println("Téléchargement terminé : " + savePath);
        } catch (IOException e) {
            System.err.println("Erreur lors du téléchargement : " + e.getMessage());
        }

    }

    public static void downloadFile(String fileURL, String savePath) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (InputStream inputStream = connection.getInputStream()) {
                Files.copy(inputStream, Path.of(savePath), StandardCopyOption.REPLACE_EXISTING);
            }
        } else {
            throw new IOException("Échec de la connexion : Code HTTP " + connection.getResponseCode());
        }
        connection.disconnect();
    }
}

