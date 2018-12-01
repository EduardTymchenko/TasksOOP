import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinksHtml {
    private  String urlSite;

    public LinksHtml(String urlSite) {
        this.urlSite = urlSite;
    }

    private String readURL() {
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConnection = null;
        URL url = null;
        try {
            url = new URL(urlSite);
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            char[] charBuffer = new char[10000];
            int read;
            while ((read = br.read(charBuffer)) > 0) {
                sb.append(new String(charBuffer, 0, read));
            }
        } catch (IOException e) {
            System.out.println("Error read from " + url + " : " + e.getMessage());
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
        }
        return sb.toString();
    }

    private String getLinks() {
        String inSring = readURL();
        int position = 0;
        char ch;
        StringBuilder sb = new StringBuilder();
        while (position >= 0) {
            position = inSring.indexOf("<a ", position);
            if (position >= 0) {
                position += "<a ".length();
                position = inSring.indexOf("href=\"", position);
                if (position >= 0) {
                    position += "href=\"".length();
                    do {
                        ch = inSring.charAt(position++);
                        if (ch != '"') sb.append(ch);
                    } while (ch != '"');
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public void writeToFile(String fileName) {
        String path = "Task11_3/" + fileName;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(getLinks());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
