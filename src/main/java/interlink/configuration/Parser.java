package interlink.configuration;


import java.net.URI;
import java.net.URISyntaxException;

public class Parser {
    private String url;
    private String user;
    private String password;

    public Parser(String fullUrl) throws URISyntaxException {
        URI uri = new URI(fullUrl);
        String afterJdbc = uri.getScheme() + "ql://";
        String host = uri.getHost();
        String nameDb = uri.getPath();
        String name = uri.getUserInfo();
        String needPart = "?sslmode=require";
        String jdbc = "jdbc:";
        int port = uri.getPort();
        this.url = jdbc + afterJdbc + host + ":" + port + nameDb + needPart;
        this.user = name.substring(0, name.indexOf(":"));
        this.password = name.substring(name.indexOf(":") + 1);
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
